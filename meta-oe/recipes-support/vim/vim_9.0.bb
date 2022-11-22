require vim.inc

RDEPENDS_${PN} = "ncurses-terminfo-base"
# Recommend that runtime data is installed along with vim
RRECOMMENDS_${PN} = "${PN}-syntax ${PN}-help ${PN}-tutor ${PN}-vimrc ${PN}-common"

PACKAGECONFIG_class-native = ""
BBCLASSEXTEND = "native nativesdk"

# We override the default in security_flags.inc because vim (not vim-tiny!) will abort
# in many places for _FORTIFY_SOURCE=2.  Security flags become part of CC.
#
lcl_maybe_fortify = "${@oe.utils.conditional('DEBUG_BUILD','1','','-D_FORTIFY_SOURCE=1',d)}"
