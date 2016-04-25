DESCRIPTION = "TCP/IP packet demultiplexer"
HOMEPAGE = "http://www.digitalcorpora.org"
SECTION = "util/security"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
LICENSE = "GPLv3"

DEPENDS = "boost openssl libpcap cairo"

SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/universe/t/${BPN}/${BPN}_${PV}+repack1.orig.tar.gz "

SRC_URI[md5sum] = "deab473e95a68a808f4d633034c3bb3a"
SRC_URI[sha256sum] = "1d9b4ce2dd85adc1c608f34ada576b7f5b6d51c686ae6b870c3c277049a24af0"

S = "${WORKDIR}/${BPN}"
inherit autotools pkgconfig

OECONF_EXTRA += "--without-o3"
OEMAKE_EXTRA += "-std=gnu++11 CPPFLAGS='${CPPFLAGS}"
