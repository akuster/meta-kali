DESCRIPTION = "fake keyboard/mouse input, window management, and more"
HOMEPAGE = "https://github.com/jordansissel/xdotool.git"
LICENSE = "xdotool"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=1234"

SRCREV = "f5309ecea01463b3bddb4964978631cd201fb7c6"
SRC_URI = "git://github.com/jordansissel/xdotool.git"

S = "${WORKDIR}/git"

inherit autotools
