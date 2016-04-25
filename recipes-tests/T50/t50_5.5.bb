DESCRIPTION = "Very fast network stress tool"
LICENSE = "GPLv2"
SECTION = "testing/security"
LIC_FILES_CHKSUM = "file://LICENSE;md5=75859989545e37968a99b631ef42722e"

SRCREV = "75db57c293175fa897439c3ef5effeb8c6ebcb4f"
SRC_URI = "git://github.com/fredericopissarra/t50"

inherit autotools-brokensep

S = "${WORKDIR}/git"

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
