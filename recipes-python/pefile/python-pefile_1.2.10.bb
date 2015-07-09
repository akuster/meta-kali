SUMMARY = " Portable Executable reader module"
HOMEPAGE = "http://code.google.com/p/pefile/"
SECTION = "devel/python"
LICENSE = "pefile"
LIC_FILES_CHKSUM = "file://COPYING;md5=05f9d5f32f2fadd166679570cc7b8865"
SRCNAME = "pefile"

SRC_URI = "http://pefile.googlecode.com/files/${SRCNAME}-${PV}-139.tar.gz"
SRC_URI[md5sum] = "f10a94320bfaca356fff4d28c41e9278"
SRC_URI[sha256sum] = "8b7c5d853c97a923d0f6e128d0ae76b962aa75fd608d552f5a32e46276908a16"
S = "${WORKDIR}/${SRCNAME}-${PV}-139"

inherit setuptools

RDEPENDS_${PN} = "python-mmap"

BBCLASSEXTEND = "native"
