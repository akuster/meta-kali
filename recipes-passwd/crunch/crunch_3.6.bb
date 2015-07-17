DESCRIPTION = "crunch - wordlist generator"
HOMEPAGE = "http://sourceforge.net/projects/crunch-wordlist/files/"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
LICENSE = "GPL-2.0"

SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/universe/c/crunch/crunch_3.6.orig.tar.gz"

SRC_URI[md5sum] = "1cbab783805d1bd382bd2edf33298108"
SRC_URI[sha256sum] = "6a8f6c3c7410cc1930e6854d1dadc6691bfef138760509b33722ff2de133fe55"

inherit autotools-brokensep

do_configure[noexec] = "1"

do_compile () {
    make PREFIX=${prefix} CC="${CC}"
}

do_install () {
    install -d ${D}/${bindir}
    install -d ${D}/${mandir}/man1
    install -d ${D}/${docdir}/crunch
    install -d ${D}/${datadir}/crunch
    install -m 755 crunch ${D}/${bindir}
    install -m 644 *.lst ${D}/${datadir}/crunch
    install -m 644 COPYING ${D}/${docdir}/crunch
    install -m 644 crunch.1 ${D}/${mandir}/man1
}
