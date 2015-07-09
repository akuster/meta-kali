SUMMARY = "Capstone disassembly engine"
HOMEPAGE = "https://pypi.python.org/pypi/capstone"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=1cfbff4f40612b0144e498a47c91499c"
SRCNAME = "capstone"

SRC_URI = "https://pypi.python.org/packages/source/c/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
SRC_URI[md5sum] = "03c82db9110378f4b4575f560445eb46"
SRC_URI[sha256sum] = "0cb5206a5358a55f516b7a958da278466fc378f837187cb4f9df77f367e5e80a"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

do_install_append () {
    install -d ${D}/${libdir}
    install -m 644 ${S}/src/libcapstone.so ${D}/${libdir}
}

FILES_${PN} = "${libdir}/python*"

BBCLASSEXTEND = "native"
