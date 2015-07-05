DESCRIPTION = "Lynis is a security auditing tool for Unix and Linux based systems. It performs in-depth security scans, with almost no configuration."
HOMEPAGE = "https://cisofy.com"
SECTION = "audit/security"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3edd6782854304fd11da4975ab9799c1"


SRC_URI = "https://cisofy.com/files/lynis-2.1.0-88394c1affb9e23bd7390098947b3fd4b04e35e8.tar.gz"

SRC_URI[md5sum] = "7f201fea70aeeed35b4d5bbdb5370fec"
SRC_URI[sha256sum] = "16ed596c8c283b8e4c635ada25ceb042371384ae09b3238a658ca60801a73c24"

S = "${WORKDIR}/${PN}"

do_compile () {
    gzip -9c ${S}/lynis.8 > ${B}/lynis.8.gz
}

do_install () {
#    PLUGINDIR
#    DBDIR
#    INCLUDEDIR
    install -d ${D}/${sbindir}
    install -d ${D}/${sysconfdir}/${PN}
    install -d ${D}/${sysconfdir}/${PN}/plugins
    install -d ${D}/${docdir}/${PN}
    install -d ${D}/${datadir}/${PN}/db
    install -d ${D}/${datadir}/${PN}/extras
    install -d ${D}/${datadir}/${PN}/include
    install -d ${D}/${mandir}/man8

    install -m 755 ${B}/lynis ${D}/${sbindir}
    install -m 644 ${B}/README ${D}/${sysconfdir}/${PN}
    install -m 644 ${B}/default.prf ${D}/${sysconfdir}/${PN}
    install -m 644 ${B}/plugins/custom_plugin.template ${D}/${sysconfdir}/${PN}/plugins

    install -m 644 ${B}/include/* ${D}/${datadir}/${PN}/include
    install -m 644 ${B}/db/* ${D}/${datadir}/${PN}/db
    install -m 755 ${B}/lynis.8.gz ${D}/${mandir}/man8
}

PACKAGES = "${PN}"

FILES_${PN} = "${sbindir} ${docdir} ${sysconfdir}/${PN} ${mandir}/man8 ${datadir}/${PN}"
