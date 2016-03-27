DESCRIPTION = "Very fast network stress tool"
LICENSE = "GPLv2"
SECTION = "testing/security"
LIC_FILES_CHKSUM = "file://LICENSE;md5=75859989545e37968a99b631ef42722e"

SRC_URI = "http://sourceforge.net/projects/${PN}/files/${PN}-${PV}/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "47a76380f3ea6a4bf44a8d0c19cd5ff4"
SRC_URI[sha256sum] = "f6205a47e45d49524d4bcdf3f5e68d515630c1408b60f0addb01f9901d64834a"

inherit autotools-brokensep

S = "${WORKDIR}"

do_configure () {
    :
}

do_compile () {
    make CC="${CC}" DEBUG=1
    gzip -9c ${S}/doc/t50.8 > ${S}/release/t50.8.gz
}

do_install () {
    install -d ${D}/${bindir}
    install -d ${D}/${mandir}/man8
    install -d ${D}/${docdir}/t50

    install -m 755 ${B}/release/t50 ${D}/${bindir}
    install -m 644 ${B}/release/t50.8.gz ${D}/${mandir}/man8
    install -m 644 ${B}/doc/README.modules ${D}/${docdir}/t50
}
