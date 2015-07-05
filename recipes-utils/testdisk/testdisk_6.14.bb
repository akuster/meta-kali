SUMMARY = "TestDisk is powerful free data recovery software!"
DESCRIPTION = "It was primarily designed to help recover lost partitions and/or make non-booting disks bootable again when these symptoms are caused by faulty software: certain types of viruses or human error (such as accidentally deleting a Partition Table). Partition table recovery using TestDisk is really easy."
HOMEPAGE = "http://www.cgsecurity.org/wiki/TestDisk"
SECTION = "security"
LICENSE = "GPLv2+"

DEPENDS = "e2fsprogs zlib util-linux"

LIC_FILES_CHKSUM = "file://COPYING;beginline=1;endline=2;md5=1fbd81241fe252ec0f5658a521ab7dd8"

SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/universe/t/${PN}/${PN}_${PV}.orig.tar.bz2"

SRC_URI[md5sum] = "b1f0edabc9035e9ec9c8e0a95059ff3f"
SRC_URI[sha256sum] = "a597c3ebc375acdf0ff60f44ed8935a301132aae78ec00f64f091637d055326c"

inherit autotools-brokensep  pkgconfig

PACKAGECONFIG ?= ""
PACKAGECONFIG[ncurses] = "--with-ncurses-lib=${STAGING_INCDIR} --with-ncurses-includes=${STAGING_LIBDIR}, --without-ncurses, ncurses,"

PACKAGECONFIG[jpeg] = "--with-jpeg-lib=${STAGING_INCDIR} --with-jpeg-includes=${STAGING_LIBDIR}, --without-jpeg, jpeg,"
