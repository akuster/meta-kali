DESCRIPTION = "THC-IPV6-ATTACK-TOOLKIT"
HOMEPAGE = "www.thc.org"
SECTION  = "test/security"
LICENSE = "AGPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=03965fd36eca19b6e2df3edc0f6decaf\
                    file://LICENSE.OPENSSL;md5=1b8a77c17384b5f2a97bd17d7129ecce"

DEPENDS = "openssl libpcap"

SRCREV = "882dbb44301e11e4e744775eca942662a0f8f335"
SRC_URI = "git://github.com/vanhauser-thc/thc-ipv6.git"

S = "${WORKDIR}/git"

inherit autotools-brokensep

do_compile () {
    make CC="${CC}" PREFIX="${prefix}"
}

do_install () {
    make DESTDIR=${D} install 
}

localdir = "${prefix}/local"
localbin = "${localdir}/bin"
localdata = "${localdir}/share"
localman = "${localdata}/man"

FILES_${PN} += "${localbin}"
FILES_${PN}-dbg += "${localbin}/.debug"
FILES_${PN}-doc += "${localman}/man8"

RDEPENDS_${PN} += "bash"
