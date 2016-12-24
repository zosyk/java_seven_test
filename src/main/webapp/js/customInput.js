/**
 * Created by alex on 12/6/16.
 */

jQuery(function ($) {
    $(".field-input").focus(function () {
        $(this).parent().addClass("is-focused has-label");
    })

    $(".field-input").blur(function () {

        $parent = $(this).parent();

        if($(this).val() == ''){
            $parent.removeClass("has-label");
        }

        $parent.removeClass("is-focused");
    })
})