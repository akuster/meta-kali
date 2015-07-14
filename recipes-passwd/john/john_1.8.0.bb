DESCRIPTION = "John the Ripper password cracker"
SUMMARY = "John the Ripper is a fast password cracker, currently available for many flavors of Unix, Windows, DOS, BeOS, and OpenVMS. Its primary purpose is to detect weak Unix passwords. Besides several crypt(3) password hash types most commonly found on various Unix systems, supported out of the box are Windows LM hashes, plus lots of other hashes and ciphers in the community-enhanced version. "
HOMEPAGE = "http://www.openwall.com/john/"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://doc/LICENSE;md5=123ff47bb528caa97868cdfc262bd96a"

DEPENDS = "pwgen-native"

SRC_URI = "http://www.openwall.com/${PN}/j/${PN}-${PV}.tar.xz \
            file://john_add_arm32.patch \
            file://arm32.h "

SRC_URI[md5sum] = "a4086df68f51778782777e60407f1869"
SRC_URI[sha256sum] = "952cf68369fb5b27f2d112ce7ca1eb16b975c85cbce8c658abb8bc5a20e1b266"

JOHN_SYSTEMWIDE_HOME="${datadir}/john"
JOHN_SYSTEMWIDE_EXEC="${libexecdir}"
JOHN_PRIVATE_HOME = "${JOHN_SYSTEMWIDE_HOME}/.john"

inherit autotools-brokensep john-arch

do_compile () {
    cp ${WORKDIR}/arm32.h ${S}/src/.
    cd ${S}/src
    # undo stripping
    export JOHN_SYSTEMWIDE_EXEC
    export JOHN_SYSTEMWIDE_HOME
    export JOHN_PRIVATE_HOME
    sed -i 's/LDFLAGS = -s \$(OMPFLAGS)/LDFLAGS = \$(OMPFLAGS)/' Makefile
    make CC="${CC} -g -DJOHN_SYSTEMWIDE=1" linux-$JOHN_ARCH
}

do_install () {
    install -d ${D}/${sbindir}
    install -d ${D}/${JOHN_PRIVATE_HOME}
    install -d ${D}/${JOHN_SYSTEMWIDE_EXEC}
    install -d ${D}/${JOHN_SYSTEMWIDE_HOME}

    install -m 644 run/ascii.chr ${D}/${datadir}/john
    install -m 644 run/digits.chr ${D}/${datadir}/john
    install -m 644 run/lm_ascii.chr ${D}/${datadir}/john
    install -m 644 run/password.lst ${D}/${datadir}/john
    install -m 644 run/john.conf ${D}/${JOHN_PRIVATE_HOME}

    install -m 755 run/john ${D}/${sbindir}
    install -m 755 run/mailer ${D}/${sbindir}
    install -m 755 run/makechr ${D}/${sbindir}
    install -m 755 run/relbench ${D}/${sbindir}

    ln -sf john ${D}/${sbindir}/unafs
    ln -sf john ${D}/${sbindir}/unique 
    ln -sf john ${D}/${sbindir}/unshadow 

    touch ${D}/${JOHN_PRIVATE_HOME}/john.ini
}

CONFFILES_${PN} = "john.conf"

FILES_${PN} += "${JOHN_SYSTEMWIDE_HOME} ${JOHN_SYSTEMWIDE_EXEC}"

RDEPENDS_${PN} = "perl"
