SUMMARY = "Braa is a mass snmp scanner."
DESCRIPTION = "The intended usage of such a tool is of course making SNMP queries – but unlike snmpget or snmpwalk from net-snmp, it is able to query dozens or hundreds of hosts simultaneously, and in a single process. Thus, it consumes very few system resources and does the scanning VERY fast. \
/n \
Braa implements its OWN snmp stack, so it does NOT need any SNMP libraries like net-snmp. The implementation is very dirty, supports only several data types, and in any case cannot be stated ‘standard-conforming’! It was designed to be fast, and it is fast. For this reason (well, and also because of my laziness ;), there is no ASN.1 parser in braa – you HAVE to know the numerical values of OID’s (for instance .1.3.6.1.2.1.1.5.0 instead of system.sysName.0)."
HOMEPAGE = "http://s-tech.elsat.net.pl/"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=18810669f13b87348459e611d31ab760"

SRC_URI = "http://s-tech.elsat.net.pl/${BPN}/${BPN}-${PV}.tar.gz"
SRC_URI += "file://fix_makefile.patch"

SRC_URI[md5sum] = "e28f8b0591672de9aaa7dcf54332f6ce"
SRC_URI[sha256sum] = "d650d34cdf30fcbbbbf4e4f11c8f5d51fd5caa3cca58d620fa1d978b8c18919c"

do_configure[noexec] = "1"

do_complie () {
    make CC="${CC}"
}

do_install () {
    install -d ${D}/${sbindir}
    install -m 755 braa ${D}/${sbindir}
}
