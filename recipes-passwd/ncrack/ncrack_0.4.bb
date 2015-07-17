DESCRIPTION = "Ncrack is a high-speed network authentication cracking too."
HOMEPAGE = "http://nmap.org/ncrack/"

LIC_FILES_CHKSUM = "file://COPYING;md5=2c507c34cd806abafe48c2bd0a511b80"
LICENSE = "GPL-2.0"

SRC_URI = "http://nmap.org/ncrack/dist/${BPN}-${PV}ALPHA.tar.gz \
    file://remove_stipping.patch"

SRC_URI[md5sum] = "db9be165469c04650ddc7403b29eb472"
SRC_URI[sha256sum] = "f8bd7e0ef68559490064ec0a5f139b2b9c49aeaf9f6323e080db9ff344c87603"

inherit autotools-brokensep pkgconfig

S = "${WORKDIR}/${BPN}-${PV}ALPHA"

do_configure () {
    ./configure ${CONFIGUREOPTS}
}

do_compile () {
    make
}

RDEPENDS_${PN} = "libssl libcrypto"
