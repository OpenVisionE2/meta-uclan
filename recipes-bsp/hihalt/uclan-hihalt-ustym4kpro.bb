SUMMARY = "halt for ${MACHINE}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(ustym4kpro)$"

RDEPENDS_${PN} = "harfbuzz"

SRCDATE = "20190603"

PV = "${SRCDATE}"

INITSCRIPT_NAME = "suspend"
INITSCRIPT_PARAMS = "start 89 0 ."
inherit update-rc.d

SRC_URI  = "http://source.mynonpublic.com/uclan/${MACHINE}-hihalt-${SRCDATE}.tar.gz \
    file://suspend.sh \
"

SRC_URI[md5sum] = "6bd5357a64dcbdbe6063cf576474b7e4"
SRC_URI[sha256sum] = "f2563f492967ebffc03eefe6baba483680204f37487cfea12963dbc0e50fe5b5"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/hihalt ${D}${bindir}
    install -d ${D}${INIT_D_DIR}
    install -m 0755 ${S}/suspend.sh ${D}${INIT_D_DIR}/suspend
}

do_package_qa() {
}

FILES_${PN}  = "${bindir}/hihalt ${INIT_D_DIR}"


