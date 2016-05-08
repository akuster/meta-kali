

DESKTOP ?= ""
PIXMAP_16_16 ?= ""
PIXMAP_22_22 ?= ""
PIXMAP_24_24 ?= ""
PIXMAP_32_32 ?= ""
PIXMAP_48_48 ?= ""
PIXMAP_64_64 ?= ""
PIXMAP_128_128 ?= ""
PIXMAP_256_256 ?= ""

python () {
    PIXMAP = []
    for PIX in ["PIXMAP_16_16", "PIXMAP_22_22", "PIXMAP_24_24", "PIXMAP_32_32", "PIXMAP_48_48", "PIXMAP_64_64", "PIXMAP_128_128", "PIXMAP_256_256"]:
        pixmap = d.getVar(PIX, True)
        if pixmap:
            pixmap = pixmap.split()
            for pix in pixmap:
                PIXMAP.append(pix)
                d.appendVar('SRC_URI', " file://%s"% pix)
}

do_install_append () {
    install -d ${D}${datadir}/applications/
    install -m 0644 ${WORKDIR}/${DESKTOP} ${D}${datadir}/applications/
    install -d ${D}${datadir}/pixmaps/
    for PIX in PIXMAP:
        install -m 0644 ${WORKDIR}/${PIX} ${D}${datadir}/pixmaps/
}

PACKAGES =+ "${PN}-x11-dbg ${PN}-x11"
DESCRIPTION_${PN}-x11 = "X11 display terminal for ${PN}."
FILES_${PN}-x11 = "${datadir}/applications ${datadir}/pixmaps"
