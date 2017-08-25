$("#continue").click(function () {
    var url = window.location.href.split('#')[0];
    window.location.href = "wxScan?url=" + url;
});