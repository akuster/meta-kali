SUMMARY = "Wireless attack tool for IEEE 802.11 networks"
DESCRIPTION = "MDK is a proof-of-concept tool to exploit common IEEE 802.11 protocol weaknesses. IMPORTANT: It is your responsibility to make sure you have permission from the network owner before running MDK against it."
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=b8c7f7d7654b933d1bebc68cbdea7c05"

SRCREV = "2fcf8a2d60eba7690bce2ef3d6f7cf5920ef792d"

SRC_URI = "${KALI_MIRROR}/${BPN}"


inherit  autotools-brokensep

S = "${WORKDIR}/git"
do_configure[noexec] = "1"

do_compile () {
    make CC="${CC}"
}

do_install () {
    make DESTDIR=${D}
}
