SUMMARY = "Passive OS fingerprinting tool"
DESCRIPTION = "P0f is a tool that utilizes an array of sophisticated, purely passive traffic fingerprinting mechanisms to identify the players behind any incidental TCP/IP communications (often as little as a single normal SYN) without interfering in any way."
HOMEPAGE = "http://lcamtuf.coredump.cx/p0f3/"
LICENSE = "LGPL-2.0"
LIC_FILES_CHKSUM = "file://p0f.c;md5=a6a828a50eaabe56164c89723c71255b"

SRC_URI = "http://lcamtuf.coredump.cx/p0f3/releases/p0f-${PV}.tgz"

SRC_URI[md5sum] = "984aad167d6f5849a5b319e11c81e2b1"
SRC_URI[sha256sum] = "da89a7fe4ba5db3704207f4bde231643bedd4fe8653ab8111c65766c8c768aec"

S = "${WORKDIR}/p0f-${PV}"

do_configure[noexec] = "1"
