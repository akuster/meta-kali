DESCRIPTION = "Patch PE, ELF, Mach-O binaries with shellcode"
HOMEPAGE = "https://github.com/secretsquirrel/the-backdoor-factory/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=16efec3c915fbeddad25d7d2bfcf335e"

SRCREV = "6fcff6bdb511ca306ec9ad29872342086714dd1d"
SRC_URI = "git://github.com/secretsquirrel/the-backdoor-factory \
"

S = "${WORKDIR}/git"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
    install -d ${D}/${datadir}/${PN}
    install -d ${D}/${docdir}/${PN}

    install -m 755 *.py ${D}${datadir}/${PN}
    cp -a intel ${D}${datadir}/${PN}
    cp -a arm ${D}${datadir}/${PN}
    cp -a asm ${D}${datadir}/${PN}
    cp -a winapi ${D}${datadir}/${PN}
    install -m 644 COPYING  ${D}/${docdir}/${PN}
}

RDEPENDS_${PN} = "python-core python-shell python-ctypes \
                  python-distutils python-pefile python-capstone"

