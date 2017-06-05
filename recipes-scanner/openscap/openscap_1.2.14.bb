# Copyright (C) 2017 Armin Kuster  <akuster808@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMARRY = "NIST Certified SCAP 1.2 toolkit"
HOME_URL = "https://www.open-scap.org/tools/openscap-base/"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"
LICENSE = "LGPL-2.1"

DEPENDS = "autoconf-archive pkgconfig gconf procps curl libxml2 \
          libxslt libcap swig swig-native "

DEPENDS_class-native = "autoconf-archive-native pkgconfig-native swig-native curl-native libxml2-native libxslt-native"

DEPENDS_append_libc-musl = " musl-fts"

SRCREV = "f7581a21bfba6920a691ec0c2edb25ab08f77d4a"
SRC_URI = "git://github.com/OpenSCAP/openscap.git;branch=maint-1.2 \
           file://crypto_pkgconfig.patch \
           file://musl_build_fix.patch \
           file://run-ptest \
"

inherit autotools-brokensep pkgconfig python3native perlnative ptest

S = "${WORKDIR}/git"

PACKAGECONFIG ?= "nss3 pcre python3"
PACKAGECONFIG[pcre] = ",--enable-regex-posix, libpcre"
PACKAGECONFIG[gcrypt] = "--with-crypto=gcrypt,, libgcrypt "
PACKAGECONFIG[nss3] = "--with-crypto=nss3,, nss"
PACKAGECONFIG[python] = "--enable-python, --disable-python, python, python"
PACKAGECONFIG[python3] = "--enable-python3, --disable-python3, python3, python3"
PACKAGECONFIG[perl] = "--enable-perl, --disable-perl, perl, perl"

EXTRA_OECONF += "--disable-probes-independent --enable-probes-linux \
		--disable-probes-solaris --disable-probes-unix \
		--enable-util-oscap-ssh --enable-util-oscap --enable-ssp --enable-sce \
"

do_configure_prepend () {
	sed -i 's:-I/usr/include:-I${STAGING_INCDIR}:' ${S}/swig/perl/Makefile.am
	sed -i 's:-I/usr/include:-I${STAGING_INCDIR}:' ${S}/swig/python3/Makefile.am
	sed -i 's:-I/usr/include:-I${STAGING_INCDIR}:' ${S}/swig/python2/Makefile.am
}


include openscap.inc

do_configure_append_class-native () {
	sed -i 's:OSCAP_DEFAULT_CPE_PATH.*$:OSCAP_DEFAULT_CPE_PATH "${STAGING_OSCAP_BUILDDIR}${datadir_native}/openscap/cpe":' ${S}/config.h
	sed -i 's:OSCAP_DEFAULT_SCHEMA_PATH.*$:OSCAP_DEFAULT_SCHEMA_PATH "${STAGING_OSCAP_BUILDDIR}${datadir_native}/openscap/schemas":' ${S}/config.h
	sed -i 's:OSCAP_DEFAULT_XSLT_PATH.*$:OSCAP_DEFAULT_XSLT_PATH "${STAGING_OSCAP_BUILDDIR}${datadir_native}/openscap/xsl":' ${S}/config.h
}

do_clean[cleandirs] += " ${STAGING_OSCAP_BUILDDIR}"

do_install_append_class-native () {
	oscapdir=${STAGING_OSCAP_BUILDDIR}/${datadir_native}
	install -d $oscapdir	
	cp -a ${D}/${STAGING_DATADIR_NATIVE}/openscap $oscapdir
}

TESTDIR = "tests"

do_compile_ptest() {
    echo 'buildtest-TESTS: $(check)' >> ${TESTDIR}/Makefile
    oe_runmake -C ${TESTDIR} buildtest-TESTS
}

do_install_ptest() {
    # install the tests
    #cp -rf ${S}/${TESTDIR} ${D}${PTEST_PATH}
    cp -rf ${B}/${TESTDIR} ${D}${PTEST_PATH}
}

FILES_${PN} += "${PYTHON_SITEPACKAGES_DIR}"

RDEPENDS_${PN} += "libxml2"
RDEPENDS_${PN}_libc-musl = "musl-fts-dev"

BBCLASSEXTEND = "native"

