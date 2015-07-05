DESCRIPTION = "Very fast network stress tool"
LICENSE = "GPLv2"
SECTION = "testing/security"
LIC_FILES_CHKSUM = "file://LICENSE;md5=75859989545e37968a99b631ef42722e"

SRC_URI = "http://sourceforge.net/projects/${PN}/files/${PN}-${PV}/${BP}-rc1.tar.gz"
SRC_URI[md5sum] = "8ca6681158dcf9f8cfba4b3ca91332b7"
SRC_URI[sha256sum] = "6c17c219f2fa5e56a71c62e1a4c045866a719ab03078a56ed62e66d30a3c79a8"

S = "${WORKDIR}/${PN}"

inherit autotools-brokensep
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
