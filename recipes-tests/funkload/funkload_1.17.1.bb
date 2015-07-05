DESCRIPTION = "Functional and load web tester."
HOMEPAGE = "http://funkload.nuxeo.org/"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://src/funkload/Distributed.py;md5=3e6ceca1619fb15119914891be478ba2"

SRCREV = "b55f52cdbbec39fb140f29414c46ec5e445d54bd"
SRC_URI = "git://github.com/nuxeo/FunkLoad.git"

inherit setuptools

S = "${WORKDIR}/git"
