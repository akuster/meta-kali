DESCRIPTION = "SlowHTTPTest is a highly configurable tool that simulates some Application Layer Denial of Service attacks."
HOMEPAGE = "https://github.com/shekyan/slowhttptest"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9faa4d26034f11966c7aa5378c085cdf"

SRCREV = "7d1f6a00e8398805dc103cfe3d3be5838ec72da0"
SRC_URI = "git://github.com/shekyan/slowhttptest.git \
            file://clean_makefiles.patch"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

RDEPENDS_${PN} = "libssl"
