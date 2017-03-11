DESCRIPTION = "rootkit detector"
SUMMARY = "locally checks for signs of a rootkit"
HOMEPAGE = "http://www.chkrootkit.org/"
SECTION = "security"
LICENSE = "GPLv2.0"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=fdbe53788f7081c63387d8087273f5ff"

SRC_URI = "https://fossies.org/linux/misc/${BP}.tar.gz"
SRC_URI[md5sum] = "f021156de4ad6dff0eda3399228f6cb9"
SRC_URI[sha256sum] = "8301782051f0b8cd213c323624d42fbecd101a583646caef126166dc2852fc25"

inherit autotools-brokensep

TARGET_CC_ARCH += "${LDFLAGS}"

do_configure () {
    sed -i 's/@strip.*$//' ${S}/Makefile
}

do_compile () {
    make CC="${CC}" LDFLAGS="${LDFLAGS}" sense
    gzip -9vkf ACKNOWLEDGMENTS
    gzip -9vkf README
}

do_install () {
    install -d ${D}/${libdir}/${PN}
    install -d ${D}/${sbindir}
    install -d ${D}/${docdir}/${PN}

    install -m 644 ${B}/chkdirs ${D}/${libdir}/${PN}
    install -m 644 ${B}/chklastlog ${D}/${libdir}/${PN}
    install -m 644 ${B}/chkproc ${D}/${libdir}/${PN}
    install -m 644 ${B}/chkutmp ${D}/${libdir}/${PN}
    install -m 644 ${B}/chkwtmp ${D}/${libdir}/${PN}
    install -m 644 ${B}/ifpromisc ${D}/${libdir}/${PN}
    install -m 644 ${B}/strings-static ${D}/${libdir}/${PN}

    install -m 755 ${B}/chklastlog ${D}/${sbindir}
    install -m 755 ${B}/chkrootkit ${D}/${sbindir}
    install -m 755 ${B}/chkwtmp ${D}/${sbindir}

    install -m 644 ${B}/ACKNOWLEDGMENTS.gz ${D}/${docdir}/${PN}
    install -m 644 ${B}/README.chklastlog ${D}/${docdir}/${PN}
    install -m 644 ${B}/README.chkwtmp ${D}/${docdir}/${PN}
    install -m 644 ${B}/README.gz ${D}/${docdir}/${PN}
    install -m 644 ${B}/COPYRIGHT ${D}/${docdir}/${PN}
}
