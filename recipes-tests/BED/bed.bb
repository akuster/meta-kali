SUMMARY = "A network protocol fuzzer"
DESCRIPTION = "BED is a program which is designed to check daemons for potential buffer overflows, format strings et. al."
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://docs/gpl.txt;md5=393a5ca445f6965873eca0259a17f833"

SRCREV = "e6ba3ebc05553df2e609bf1f461cb537fe30f1c8"
PV = "0.5+git${SRCPV}"

DESKTOP = "kali-bed.desktop"
PIXMAP_16_16 = "16x16/kali-menu.png"
PIXMAP_32_32 = "32x32/kali-menu.png"

SRC_URI = "${KALI_MIRROR}/${BPN}"

inherit  autotools-brokensep x11_menu

S = "${WORKDIR}/git"

do_configure[noexec] = "1"
do_compile[noexec] = "1"
do_install () {
    install -d ${D}/${sysconfdir}/${BPN}
    install -d ${D}/${bindir}
    install -d ${D}/${docdir}/${BPN}

    cp -a bedmod ${D}/${sysconfdir}/${BPN}
    cp -a docs ${D}/${docdir}/${BPN}
    install -m 755 bed.pl ${D}/${bindir}
    chown -R root:root ${D}/${sysconfdir}/${BPN}
}

RDEPENDS_${PN} = "perl"
