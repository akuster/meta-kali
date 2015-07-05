DESCRIPTION =  "A security assessment and troubleshooting tool for the IPv6 protocols"
SUMMARY = "The SI6 Networks' IPv6 toolkit is a set of IPv6 security assessment and trouble-shooting tools. It can be leveraged to perform security assessments of IPv6 networks, assess the resiliency of IPv6 devices by performing real-world attacks against them, and to trouble-shoot IPv6 networking problems. The tools comprising the toolkit range from packet-crafting tools to send arbitrary Neighbor Discovery packets to the most comprehensive IPv6 network scanning tool out there (our scan6 tool)."

HOMEPAGE = "http://www.si6networks.com"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "libpcap"

SRC_URI = "http://www.si6networks.com/tools/${PN}/${PN}-v${PV}.tar.gz"

SRC_URI[md5sum] = "9274f87dd5f57da78c08998e283ad7ed"
SRC_URI[sha256sum] = "16f13d3e7d17940ff53f028ef0090e4aa3a193a224c97728b07ea6e26a19e987"

S = "${WORKDIR}/${PN}-v${PV}"

do_compile () {
    make CC="${CC}" CFLAGS="${CFLAGS} -L${STAGING_LIBDIR} -lpcap -lm " LDFLAGS="${LDFLAGS}" PREFIX=${prefix} MANPREFIX=${mandir}
}

do_install () {
    make DESTDIR=${D} PREFIX=${prefix} MANPREFIX=${mandir} install
}

RDEPENDS_${PN} = "perl"
