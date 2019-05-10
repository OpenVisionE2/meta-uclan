SUMMARY = "halt for Uclan Model ${MACHINE}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "ustym4kpro"

RDEPENDS_${PN} = "harfbuzz"

SRCDATE = "20180823"

PV = "${SRCDATE}"

INITSCRIPT_NAME = "suspend"
INITSCRIPT_PARAMS = "start 89 0 ."
inherit update-rc.d

SRC_URI  = "http://source.mynonpublic.com/uclan/${MACHINE}-hihalt-${SRCDATE}.tar.gz \
    file://suspend.sh \
"

SRC_URI[md5sum] = "b46b23d07684d83f7cb3511c78e87908"
SRC_URI[sha256sum] = "714076da36959138ec9322d7e6ee50015df675591a47bbf4b9a5f7f094293f5b"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/hihalt ${D}/${bindir}
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${S}/suspend.sh ${D}${sysconfdir}/init.d/suspend
}

do_package_qa() {
}

FILES_${PN}  = "${bindir}/hihalt ${sysconfdir}/init.d"


