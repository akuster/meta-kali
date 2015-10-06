DESCRIPTION = "Capstone is a lightweight multi-platform, multi-architecture disassembly framework."
HOMEPAGE = "http://www.capstone-engine.org/index.html"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=1cfbff4f40612b0144e498a47c91499c"
LICENSE = "BSD"

SRC_URI = "http://www.capstone-engine.org/download/${PV}/${PN}-${PV}.tgz"

SRC_URI[md5sum] = "ee8b90ac5a26e21d9a9f58871a8f0844"
SRC_URI[sha256sum] = "fc2741e7bc5fb23e2f960a54da3fe9858cf01ff45a1cf9bacb88a5870d0dec6e"

inherit cmake

do_install_append() {
    mv ${D}${libdir}/libcapstone.so ${D}${libdir}/libcapstone.so.${PV}
    ln -sf libcapstone.so.${PV} ${D}${libdir}/libcapstone.so
    ln -sf libcapstone.so.${PV} ${D}${libdir}/libcapstone.so.0
}

