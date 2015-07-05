DESCRIPTION = "THC-SSL-DOS is a tool to verify the performance of SSL."
SUMMARY = "Establishing a secure SSL connection requires 15x more processing \
power on the server than on the client.\ 
THC-SSL-DOS exploits this asymmetric property by overloading the \
server and knocking it off the Internet."

HOMEPAGE = "http://www.thc.org"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://src/thc-ssl-dos.c;md5=60d77843d8dbd83c3e10a9de2fc71f3f"

DEPENDS = "openssl libnl"

SRC_URI = "https://www.thc.org/${PN}/${BP}.tar.gz \
            file://fixup_configure.patch"

SRC_URI[md5sum] = "0d75fc5d6aaf22130c57436fea3ca339"
SRC_URI[sha256sum] = "3e8dcaedf39a11ebaeac6e4d75175fcc724c6255904ef4e27bf72c9788119a04"

inherit autotools-brokensep pkgconfig

EXTRA_OECONF ="--with-includes=${STAGING_INCDIR} --with-libs=${STAGING_LIBDIR}"

do_configure () {
    cd ${S}
    ./bootstrap
    ./configure ${CONFIGUREOPTS} ${EXTRA_OECONF}
}

do_compile () {
    make CC="${CC}" CFLAGS="${CFLAGS}" 
}

do_install () {
    install -d ${D}/${sbindir}
    install -m 755 ${B}/src/thc-ssl-dos ${D}/${sbindir}
}
