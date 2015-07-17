DESCRIPTION = "Passive DNS network mapper a.k.a. subdomains bruteforcer"
HOMEPAGE = "https://code.google.com/p/dnsmap/"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://gpl-2.0.txt;md5=12345"

SRCREV = "6a338197fd8de70e13d400f424dc5aa1e46fc8af"
PV = "0.30+git${SRCPV}"

SRC_URI = "git://git.kali.org/packages/dnsmap.git"


S = "${WORKDIR}/git"

do_configure[noexec] = "1"

do_compile () {
    make CC="${CC}"
}

do_install () {
    install -d ${D}/${sbindir}
    install -d ${D}/${docdir}/${BPN}
    install -m 755 dnsmap ${D}/${sbindir}
    install -m 755 dnsmap-bulk.sh ${D}/${sbindir}
    install -m 644 *.txt ${D}/${docdir}/${BPN}
}
