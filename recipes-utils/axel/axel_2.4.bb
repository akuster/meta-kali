SUMMARY = "Light download accelerator - console version"
SECTION = "security"
LICENSE = "GPLv2+"

DEPENDS = ""

LIC_FILES_CHKSUM = "file://COPYING;beginline=1;endline=2;md5=1fbd81241fe252ec0f5658a521ab7dd8"

SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/universe/a/${PN}/${PN}_${PV}.orig.tar.gz"

SRC_URI[md5sum] = "a2a762fce0c96781965c8f9786a3d09d"
SRC_URI[sha256sum] = "359a57ab4e354bcb6075430d977c59d33eb3e2f1415a811948fa8ae657ca8036"

inherit autotools-brokensep

EXTRA_OECONF = "--prefix=${prefix} --debug=0 --strip=0 --i18n=0"

do_configure () {
    ./configure ${EXTRA_OECONF}
}

do_compile () {
    make
}

do_install () {
    cd ${S}
    make DESTDIR=${D} install
}
#axelrc.example
