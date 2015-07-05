DESCRIPTION = "TCP/IP packet demultiplexer"
HOMEPAGE = "http://www.digitalcorpora.org"
SECTION = "util/security"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
LICENSE = "GPLv3"

DEPENDS = "boost openssl libpcap cairo"

SRC_URI = "http://www.digitalcorpora.org/downloads/tcpflow/${BP}.tar.gz \ 
            file://remove_spfx_check.patch"

SRC_URI[md5sum] = "f395fea6f5fe136543f4c982beff9cba"
SRC_URI[sha256sum] = "b6f5605e7e3f71d004736f4ded9e2a4f5c2233d3423019f3dc0af56037ed544c"

inherit autotools pkgconfig

OECONF_EXTRA += "--without-o3"
