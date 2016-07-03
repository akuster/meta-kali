HOMEPAGE = "http://lcamtuf.coredump.cx/afl/"

LIC_FILES_CHKSUM = "file://docs/COPYING;md5=3b83ef96387f14655fc854ddc3c6bd57" 
LICENSE = "Apache-2.0"

SRC_URI = "http://lcamtuf.coredump.cx/afl/releases/${BPN}-${PV}b.tgz"

SRC_URI[md5sum] = "e3434b3971e62050861171056959f205"
SRC_URI[sha256sum] = "907154515bd15c33556ae9ddc06c5c54be1956f36982c8d38e5a09ab3977b11d"

S = "${WORKDIR}/${BPN}-${PV}b"

localdir = "${prefix}/local"
localbin = "${localdir}/bin"
locallib = "${localdir}/lib"
localdatadir = "${localdir}/share"

do_configure[noexec] = "1"

do_compile () {
	oe_runmake
}

do_install () {
	oe_runmake install DESTDIR=${D}
}

PACKAGES += "${PN}-testcases"

FILES_${PN} += "${localbin}/* ${locallib}/*"
FILES_${PN}-doc += "${localdatadir}/doc/*"
FILES_${PN}-testcases = "${localdatadir}/afl/*"
