require p0f.inc

CFLAGS += "-g "
PROGS = "p0f-client p0f-sendsyn p0f-sendsyn"

do_compile () {
    cd ${S}/tools
    for prog in ${PROGS}; do
        ${CC} ${CFLAGS} ${LDFLAGS} ${prog}.c -o ${prog}  
    done
}

do_install () {
    cd ${S}/tools
    install -d ${D}/${bindir}
    for prog in ${PROGS}; do
        install -m 755 ${prog} ${D}/${bindir}
    done        
}

RDEPENDS_${PN} = "p0f"
