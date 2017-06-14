/*$(function () {
    $(".farm-photos .upload").uploadPreview({
        Img: ".farm-photos .photos",
        Width: 120,
        Height: 120
    });
    $(".feedback-photos .upload").uploadPreview({
        Img: ".feedback-photos .photos",
        Width: 120,
        Height: 120
    });
});
jQuery.fn.extend({
    uploadPreview: function (opts) {
        var _self = this,
            _this = $(this);
        opts = jQuery.extend({
            Img: "tupian",
            Width: 100,
            Height: 100,
            ImgType: ["gif", "jpeg", "jpg", "bmp", "png"],
            Callback: function () {}
        }, opts || {});
        _self.getObjectURL = function (file) {
            var url = null;
            if (window.createObjectURL != undefined) {
                url = window.createObjectURL(file);
            } else if (window.URL != undefined) {
                url = window.URL.createObjectURL(file);
            } else if (window.webkitURL != undefined) {
                url = window.webkitURL.createObjectURL(file);
            }
            return url;
        }
        _this.change(function () {
            if (this.value) {
                if (!RegExp("\.(" + opts.ImgType.join("|") + ")$", "i").test(this.value.toLowerCase())) {
                    alert("选择文件错误,图片类型必须是" + opts.ImgType.join("，") + "中的一种");
                    this.value = "";
                    return false;
                }
                if ($(opts.Img).find("img").length > 2 || $("." + opts.Img).find("div").length > 2) {
                    return false;
                }
                if (navigator.userAgent.indexOf("MSIE") > -1) {
                    try {
                        $(opts.Img).append('<img src="' + _self.getObjectURL(this.files[0]) + '" />');
                    } catch (e) {
                        var src = "";
                        _self.select();
                        if (top != self) {
                            window.parent.document.body.focus();
                        } else {
                            _self.blur();
                        }
                        src = document.selection.createRange().text;
                        document.selection.empty();
                        var img = document.createElement("div");
                        console.log(img)
                        $(img).css({
                            "filter": "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='scale',src=\"" + src + "\")",
                            'width': opts.Width + 'px',
                            'height': opts.Height + 'px'
                        });
                        $(opts.Img).append(img);
                    }
                } else {
                    $(opts.Img).append('<img src="' + _self.getObjectURL(this.files[0]) + '" />');
                }
                opts.Callback();
            }
        });
    }
});*/

$(".farm-photos .upload").live("change", function () {
    var opts = {
            Img: ".farm-photos .photos"
        },
        _this = $(this);
    if (this.value) {
        _this.hide();
        if ($(opts.Img).find("img").length > 2 || $(opts.Img).find("div").length > 2) {
            return false;
        } else if ($(opts.Img).find("img").length == 2 || $(opts.Img).find("div").length == 2) {
            $(".farm-photos .upload-photos").append('<input type="file" name="bannerUrl" class="upload" disabled>')
        } else {
            $(".farm-photos .upload-photos").append('<input type="file" name="bannerUrl" class="upload">')
        }
        if (navigator.userAgent.indexOf("MSIE") > -1) {
            try {
                $(opts.Img).append('<img src="' + getObjectURL(this.files[0]) + '" />');
            } catch (e) {
                var src = "";
                _self.select();
                if (top != self) {
                    window.parent.document.body.focus();
                } else {
                    _self.blur();
                }
                src = document.selection.createRange().text;
                document.selection.empty();
                var img = document.createElement("div");
                $(img).css({
                    "filter": "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='scale',src=\"" + src + "\")",
                    'width': opts.Width + 'px',
                    'height': opts.Height + 'px'
                });
                $(opts.Img).append(img);
            }
        } else {
            $(opts.Img).append('<img src="' + getObjectURL(this.files[0]) + '" />');
        }
    }
})
$(".feedback-photos .upload").live("change", function () {
    var opts = {
            Img: ".feedback-photos .photos"
        },
        _this = $(this);
    if (this.value) {
        _this.hide();
        if ($(opts.Img).find("img").length > 2 || $(opts.Img).find("div").length > 2) {
            return false;
        } else if ($(opts.Img).find("img").length == 2 || $(opts.Img).find("div").length == 2) {
            $(".feedback-photos .upload-photos").append('<input type="file" name="bannerUrl" class="upload" disabled>')
        } else {
            $(".feedback-photos .upload-photos").append('<input type="file" name="bannerUrl" class="upload">')
        }
        if (navigator.userAgent.indexOf("MSIE") > -1) {
            try {
                $(opts.Img).append('<img src="' + getObjectURL(this.files[0]) + '" />');
            } catch (e) {
                var src = "";
                _self.select();
                if (top != self) {
                    window.parent.document.body.focus();
                } else {
                    _self.blur();
                }
                src = document.selection.createRange().text;
                document.selection.empty();
                var img = document.createElement("div");
                $(img).css({
                    "filter": "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='scale',src=\"" + src + "\")",
                    'width': opts.Width + 'px',
                    'height': opts.Height + 'px'
                });
                $(opts.Img).append(img);
            }
        } else {
            $(opts.Img).append('<img src="' + getObjectURL(this.files[0]) + '" />');
        }
    }
})
var getObjectURL = function (file) {
    var url = null;
    if (window.createObjectURL != undefined) {
        url = window.createObjectURL(file);
    } else if (window.URL != undefined) {
        url = window.URL.createObjectURL(file);
    } else if (window.webkitURL != undefined) {
        url = window.webkitURL.createObjectURL(file);
    }
    return url;
}
$(".information-main .right .btn").on("click", saveReport);

function saveReport() {
    var file = $("input[name=file]"),
        form = new FormData($(".information-main .right form")[0]);
    form.append("userId", "6acedc886fbb40f3b21569646ae9f228");
    form.append("title", "Groucho");
    form.append("startTimestamp", "1497159825779");
    form.append("endTimestamp ", "1497159825779");
    form.append("publisher", "6acedc886fbb40f3b21569646ae9f228");
    $.ajax({
        url: 'http://webuploader.duapp.com/server/fileupload.php',
        type: 'POST',
        data: form,
        processData: false,
        contentType: false,
        success: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    })
    return false; // 必须返回false，否则表单会自己再做一次提交操作，并且页面跳转 
}