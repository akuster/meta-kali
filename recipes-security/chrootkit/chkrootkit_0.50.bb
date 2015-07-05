DESCRIPTION = "rootkit detector"
SUMMARY = "locally checks for signs of a rootkit"
HOMEPAGE = "http://www.chkrootkit.org/"
SECTION = "security"
LICENSE = "GPLv2.0"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=fdbe53788f7081c63387d8087273f5ff"

SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/universe/c/${PN}/${PN}_${PV}.orig.tar.gz"
SRC_URI[md5sum] = "9e67dd56f835264d43aeb04944610b03"
SRC_URI[sha256sum] = "9548fc922b0cb8ddf055faff4a4887f140a31c45f2f5e3aa64aad91ecfa56cc7"

inherit autotools-brokensep
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
