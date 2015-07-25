require p0f.inc

DEPENDS = "libpcap"

CFLAGS += "-DVERSION=\"${PV}\" -DALIGN_ACCESS=1 -g -I${STAGING_INCDIR}"

do_compile () {
    ${CC} ${CFLAGS} ${LDFLAGS} p0f.c api.c process.c fp_tcp.c fp_mtu.c fp_http.c readfp.c  -o p0f -lpcap 
}

do_install () {
    install -d ${D}/${bindir}
    install -d ${D}/${docdir}/${BPN}
    install -d ${D}/${datadir}/${BPN}
    install -m 755 p0f ${D}/${bindir}
    install -m 655 p0f.fp ${D}/${datadir}/${BPN}
    install -m 644 docs/* ${D}/${docdir}/${BPN}
}
