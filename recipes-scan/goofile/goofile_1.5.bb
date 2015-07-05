DESCRIPTION = "Command line filetype search"
HOMEPAGE = "https://code.google.com/p/goofile"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://goofile.py;md5=09666dfe1873da9d59dfb3b30b68c9d7"

SRC_URI = "http://${BPN}.googlecode.com/files/${BPN}v${PV}.zip"

SRC_URI[md5sum] = "a32a5884501d289e633fe9103d6046da"
SRC_URI[sha256sum] = "02097c39a7df04b59878f6219ed48f0509ea290cc430505023bcf79f09896a3b"

S = "${WORKDIR}/${BPN}v${PV}"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
    install -d ${D}/${sbindir}
    install -m 755 goofile.py ${D}/${sbindir}
}

RDEPENDS_${PN} = "python python-netclient"
