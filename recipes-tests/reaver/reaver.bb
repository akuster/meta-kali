SUMMARY = "Reaver implements a brute force attack against Wifi Protected Setup"
DESCRIPTION = "Reaver implements a brute force attack against Wifi Protected Setup (WPS) registrar PINs in order to recover WPA/WPA2 passphrases, as described in http://sviehb.files.wordpress.com/2011/12/viehboeck_wps.pdf. \
Reaver has been designed to be a robust and practical attack against WPS, and has been tested against a wide variety of access points and WPS implementations. \
On average Reaver will recover the target AP’s plain text WPA/WPA2 passphrase in 4-10 hours, depending on the AP. In practice, it will generally take half this time to guess the correct WPS pin and recover the passphrase"
HOMEPAGE = "https://code.google.com/p/reaver-wps/"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://../docs/LICENSE;md5=b8c7f7d7654b933d1bebc68cbdea7c05"

SRCREV = "4acad9ba2d3f7fcd08209b840a2cdab2a2bf17ac"

DESKTOP = "kali-reaver.desktop"
PIXMAP = "kali-menu.png"

SRC_URI = "${KALI_MIRROR}/${BPN}"

SRC_URI += "file://${DESKTOP}"
SRC_URI += "file://${PIXMAP}"

DEPENDS = "sqlite3 libpcap"

inherit  autotools-brokensep

S = "${WORKDIR}/git/src"

do_install () {
    install -d ${D}/${sysconfdir}/${BPN}
    install -d ${D}/${sbindir}

    install -m 755 reaver.db ${D}/${sysconfdir}/${BPN}
    install -m 755 wash ${D}/${sbindir}
    install -m 755 reaver ${D}/${sbindir}

    install -d ${D}${datadir}/applications/
    install -m 0644 ${WORKDIR}/${DESKTOP} ${D}${datadir}/applications/
    install -d ${D}${datadir}/pixmaps/
    install -m 0644 ${WORKDIR}/${PIXMAP} ${D}${datadir}/pixmaps/
}

PACKAGES =+ "${PN}-x11-dbg ${PN}-x11"
DESCRIPTION_${PN}-x11 = "X11 display terminal for ${PN}."

