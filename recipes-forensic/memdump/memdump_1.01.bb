DESCRIPTION = "utility to dump memory contents to standard output"
SUMMARY = "Program which dumps system memory to the standard output stream, skipping over holes in memory maps. By default, the program dumps the contents of physical memory."
HOMEPAGE = "http://www.porcupine.org"
SECTION = "forensic/security"

LICENSE ="IPL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=59f236b2177829954041b10e30e306d2"

SRC_URI = "http://http.debian.net/debian/pool/main/m/memdump/memdump_1.01.orig.tar.gz \
            file://fix_makedeps.patch"

SRC_URI[md5sum] = "41076a611098af79f3b893f515ae22da"
SRC_URI[sha256sum] = "76de8ff167d0779d6c3b2f2f52ca9d1cc22af179c51e976fe6e3b9a5d1e5799f"

inherit autotools-brokensep

do_compile () {
    make CC="${CC} -Wformat -Wunused" CFLAGS="${CFLAGS} -DLINUX2"
    gzip -9c ${S}/memdump.1 > ${S}/memdump.1.gz
}

do_install () {
    install -d ${D}/${sbindir}
    install -d ${D}/${mandir}/man1

    install -m 644 ${B}/memdump ${D}/${sbindir}
    install -m 644 ${B}/memdump.1.gz ${D}/${mandir}/man1
}
