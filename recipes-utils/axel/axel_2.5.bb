SUMMARY = "Light download accelerator - console version"
SECTION = "security"
LICENSE = "GPLv2+"

LIC_FILES_CHKSUM = "file://COPYING;beginline=1;endline=2;md5=1fbd81241fe252ec0f5658a521ab7dd8"

SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/universe/a/${PN}/${PN}_${PV}.orig.tar.gz"

SRC_URI[md5sum] = "77711d2e8e7129894cbbbeaaab5b0edd"
SRC_URI[sha256sum] = "02376767e7f9e6c4292333e69ad0f615f62be5df176a8daaee395f25b0ab1a83"

inherit autotools-brokensep

do_configure () {
    cd ${S}
    ./configure --prefix=${prefix} --debug=0 --strip=0 --i18n=0
}

do_compile () {
    cd ${S}
    make CC='${CC}' CFLAGS='${CFLAGS}' LDFLAGS='${LDFLAGS}'
}

do_install () {
    cd ${B}
    install -d ${D}/${mandir}/man1
    install -d ${D}/${bindir}
    install -d ${D}/${sysconfdir}/axelrc
    install -m 644 man/axel.1 ${D}/${mandir}/man1
    install -m 644 axelrc.example ${D}/${sysconfdir}/axelrc
    install -m 644 axel ${D}/${bindir}
}
