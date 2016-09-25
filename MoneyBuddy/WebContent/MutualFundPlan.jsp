<%-- 
    Document   : MutualFundPlan
    Created on : 26 Aug, 2016, 12:31:20 PM
    Author     : Savita Wadhwani
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<!--[if lt IE 7]>   <html class="no-js lt-ie10 lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>      <html class="no-js lt-ie10 lt-ie9 is-ie8"> <![endif]-->
<!--[if IE 9]>      <html class="no-js lt-ie10 is-ie9"> <![endif]-->
<!--[if gt IE 9]><!-->
<html class="no-js">
<!--<![endif]-->

<head>

    <title>MoneyBuddy - Create your plan - MoneyBuddy.com</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://invest.wealthify.com/assets/css/vendor/basic.min.css" rel="stylesheet" />
    <link href="https://invest.wealthify.com/assets/css/vendor/dropzone.min.css" rel="stylesheet" />
    <link href="https://invest.wealthify.com/assets/css/vendor/jquery-ui.min.css" rel="stylesheet" />
    <link href="https://invest.wealthify.com/assets/css/vendor/jquery-ui.theme.min.css" rel="stylesheet" />
    <link rel="shortcut icon" href="https://invest.wealthify.com/assets/images/favicons/favicon.ico" />
    <link rel="apple-touch-icon" href="https://invest.wealthify.com/assets/images/favicons/apple-touch-icon.png">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
    <script>window.Modernizr || document.write('<script src="https://invest.wealthify.com/assets/js/vendor/modernizr.min.js"><\/script>');</script>
    <!--[if lt IE 9]>
        <link rel="stylesheet" type="text/css"  href="/assets/css/ie.css" />
        <script src="/assets/js/vendor/polyfill.js"></script>
        <script src="/assets/js/vendor/excanvas.js"></script>
        <script src="/assets/js/vendor/html5shiv.min.js"></script>
         <script>
            document.defaultView = window;
        </script>
    <![endif]-->
    <link rel="stylesheet" href="https://invest.wealthify.com/assets/css/style.min.css?v=74575">
    <link rel="stylesheet" href="https://invest.wealthify.com/assets/css/print.min.css" media="print">

</head>

<body class="body-dark">
    <!-- Google Tag Manager -->
    <script>
        (function (w, d, s, l, i) {
            w[l] = w[l] || []; w[l].push({
                'gtm.start':
                new Date().getTime(), event: 'gtm.js'
            }); var f = d.getElementsByTagName(s)[0],
            j = d.createElement(s), dl = l != 'dataLayer' ? '&l=' + l : ''; j.async = true; j.src =
            '//www.googletagmanager.com/gtm.js?id=' + i + dl; f.parentNode.insertBefore(j, f);
        })(window, document, 'script', 'dataLayer', 'GTM-5R35VM');
    </script>

    End - Commented by Savita Wadhwani -->
    <!-- End Google Tag Manager -->


<header class="site-header">
    <div class="grid">
        <a href="https://www.wealthify.com" class="site-header__logo">
            <img src="https://invest.wealthify.com/assets/images/wealthify.svg" alt="Wealthify" />
        </a>

            <nav class="primary-nav">
                <div class="primary-nav__toggle">
                    <svg role="img" class="icon--hamburger"><use xlink:href="#hamburger"></use></svg>
                    <span class="primary-nav__toggle-label">Menu</span>
                </div>
                <div class="primary-nav__nav">
                        <ul class="primary-nav__main">
                            <li><a href="Dashboard.jsp">Dashboard <svg role="img" class="icon--arrow-small"><use xlink:href="#arrow-small"></use></svg></a></li>
                            <li><a href="Messages.jsp"><span class="primary-nav__notice" data-count style="display: none;"></span> Messages <svg role="img" class="icon--arrow-small"><use xlink:href="#arrow-small"></use></svg></a></li>
                            <li><a href="Circles.jsp">Circles <svg role="img" class="icon--arrow-small"><use xlink:href="#arrow-small"></use></svg></a></li>
                            <li><a href="blog.jsp">Blog <svg role="img" class="icon--arrow-small"><use xlink:href="#arrow-small"></use></svg></a></li>
                            <li><a href="helpCentre.jsp">Help <svg role="img" class="icon--arrow-small"><use xlink:href="#arrow-small"></use></svg></a></li>
                            <!--<li class="primary-nav__live-chat"><a href="javascript:void(0)" data-chat="open"><svg role="img" class="icon--livechat"><use xlink:href="#livechat"></use></svg> Live chat <svg role="img" class="icon--arrow-small"><use xlink:href="#arrow-small"></use></svg></a></li>-->
                        </ul>
                        <ul class="account-nav-dropdown">
                            <li>

                                <div class="account-nav-dropdown__text">Hello S <svg role="img" class="icon--arrow-dropdown icon--arrow-small"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#arrow-dropdown"></use></svg></div>
                                <div class="account-nav-dropdown__container">
                                    <ul>
                                        <li><a href="SignOut.jsp">Sign out <svg role="img" class="icon--arrow-small"><use xlink:href="#arrow-small"></use></svg></a></li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                </div>
            </nav>
    </div>
</header>
    <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
    <symbol id="add" viewBox="6 6 20.1 20.1">
        <path d="M26.1 16.1l-7.8-2.3L16.1 6l-2.3 7.8L6 16.1l7.8 2.2 2.3 7.8 2.2-7.8z" />
    </symbol>
    <symbol id="arrow-back" viewBox="12.9 8.2 7.1 14.3">
        <path d="M20 22.5l-7.1-7.2L20 8.2l-4 7.1z" />
    </symbol>
    <symbol id="arrow-dropdown" viewBox="4.7 10 22.3 11.1">
        <path d="M27 10L15.9 21.1 4.7 10l11.2 6.2z" />
    </symbol>
    <symbol id="arrow-sliders" viewBox="0 0 32 32">
        <path d="M17.9 9l7.1 7.1-7.1 7.1 4-7.1-4-7.1zm-7.6 7.1l4-7.1-7.1 7.1 7.1 7.1-4-7.1z" />
    </symbol>
    <symbol id="arrow-small" viewBox="12.9 8.2 7.1 14.3">
        <path d="M12.9 8.2l7.1 7.2-7.1 7.1 4-7.1z" />
    </symbol>
    <symbol id="arrow" viewBox="12.9 8.2 7.1 14.3">
        <path d="M12.9 8.2l7.1 7.2-7.1 7.1 4-7.1z" />
    </symbol>
    <symbol id="back-arrow" viewBox="12.9 8.2 7.1 14.3">
        <path d="M20 22.5l-7.1-7.2L20 8.2l-4 7.1z" />
    </symbol>
    <symbol id="bin" viewBox="0 0 40 40">
        <path d="M34.042 6H25V4c0-.552-.447-1-1-1h-8c-.552 0-1 .448-1 1v2H6c-.552 0-1 .448-1 1v3c0 .552.448 1 1 1h2v23.5c0 2.458 1 3.5 3.75 3.5h17c2.375 0 3.25-1.57 3.25-3.5V11h2c.552 0 1-.448 1-1V7c0-.552-.406-1-.958-1zM30 34.5c.03 1.5-1.97 1.5-1.97 1.5H12s-2 .042-2-1.5V11h20v23.5zM20 31.42c-.447 0-1-.216-1-.48V15.353c0-.266.553-.48 1-.48.448 0 1 .214 1 .48v15.584c0 .267-.552.483-1 .483zM14 31.42c-.52 0-1-.216-1-.48V15.353c0-.266.48-.48 1-.48s1 .214 1 .48v15.584c0 .267-.48.483-1 .483zM26 31.42c-.417 0-1-.216-1-.48V15.353c0-.266.583-.48 1-.48.418 0 1 .214 1 .48v15.584c0 .267-.582.483-1 .483z" />
    </symbol>
    <symbol id="checkmark" viewBox="0 0 32 32">
        <path stroke="#449FDB" d="M0 0" />
        <path d="M28.998 8.53l-2.134-2.133c-.394-.393-1.03-.393-1.423 0L12.647 19.192l-6.086-6.13c-.393-.393-1.03-.393-1.423 0l-2.134 2.134c-.393.394-.393 1.03 0 1.423l8.924 8.983c.393.393 1.03.393 1.423 0l15.648-15.65c.393-.39.393-1.03 0-1.422z" />
    </symbol>
    <symbol id="close" viewBox="0 0 11.3 11.3">
        <path fill-rule="evenodd" clip-rule="evenodd" d="M1.4 0l9.9 9.9-1.4 1.4L0 1.4 1.4 0zM0 9.9L9.9 0l1.4 1.4-9.9 9.9L0 9.9z" />
    </symbol>
    <symbol id="create-plan" viewBox="587 1286.2 18.1 17.2">
        <path d="M604 1299.7h-3.5c-.4-1-1.4-1.7-2.5-1.7-1.2 0-2.1.7-2.5 1.7H588c-.6 0-1 .4-1 1 0 .5.4 1 1 1h7.4c.4 1 1.4 1.7 2.5 1.7 1.2 0 2.1-.7 2.5-1.7h3.5c.6 0 1-.4 1-1 .1-.6-.3-1-.9-1zm-6 1.7c-.4 0-.7-.3-.7-.7 0-.4.3-.7.7-.7s.7.3.7.7-.3.7-.7.7zM588 1289.9h9.4c.4 1 1.4 1.7 2.5 1.7 1.2 0 2.1-.7 2.5-1.7h1.5c.6 0 1-.4 1-1 0-.5-.4-1-1-1h-1.5c-.4-1-1.4-1.7-2.5-1.7-1.2 0-2.1.7-2.5 1.7H588c-.6 0-1 .4-1 1s.4 1 1 1zm12-1.7c.4 0 .7.3.7.7 0 .4-.3.7-.7.7s-.7-.3-.7-.7c-.1-.3.3-.7.7-.7zM604 1293.8h-9.5c-.4-.9-1.4-1.6-2.5-1.6s-2.1.7-2.5 1.6H588c-.6 0-1 .4-1 1 0 .5.4 1 1 1h1.5c.4 1 1.4 1.8 2.6 1.8 1.2 0 2.2-.8 2.6-1.8h9.4c.6 0 1-.4 1-1-.1-.5-.5-1-1.1-1zm-12 1.8c-.4 0-.7-.3-.7-.7 0-.4.3-.7.7-.7s.7.3.7.7c.1.4-.3.7-.7.7z" />
    </symbol>
    <symbol id="decline" viewBox="812 911 20 20">
        <path d="M822 931c5.5 0 10-4.5 10-10s-4.5-10-10-10-10 4.5-10 10 4.5 10 10 10zm-6.1-10.7c.4-.7 1.4-.9 2-.3.7.6 1.4 1.3 2 2 .2.2.4.4.6.7h.1v-6.2c0-.6.4-1.1.9-1.3s1.1-.1 1.5.4c.3.3.4.7.4 1.1V922.8l.2-.2c.8-.8 1.5-1.6 2.3-2.3.5-.5 1-.6 1.6-.3.5.2.8.7.8 1.3 0 .3-.1.7-.4.9l-5.1 5.1c-.5.5-1.3.5-1.8 0-.2-.2-.4-.3-.5-.5l-4.4-4.4c-.5-.8-.6-1.5-.2-2.1z" />
    </symbol>
    <symbol id="double-arrow-small" viewBox="12.9 8.2 16.2 14.3">
        <path d="M22 8.2l7.1 7.2-7.1 7.1 4-7.1z" />
        <path d="M12.9 8.2l7.1 7.2-7.1 7.1 4-7.1z" />
    </symbol>
    <symbol id="double-back-arrow" viewBox="12.9 8.2 16.2 14.3">
        <path d="M20 22.5l-7.1-7.2L20 8.2l-4 7.1z" />
        <path d="M29.1 22.5L22 15.3l7.1-7.1-4 7.1z" />
    </symbol>
    <symbol id="download" viewBox="0 0 16 17">
        <path d="M6.5 7.9V1.5c0-.6.4-1.2 1-1.4C8-.1 8.7 0 9.1.5c.3.3.4.7.4 1.1V8c.1-.1.2-.2.3-.2.8-.8 1.7-1.6 2.5-2.4.5-.5 1.1-.6 1.7-.3.6.2.9.8.9 1.4 0 .4-.1.7-.4.9-1.8 1.6-3.7 3.3-5.5 5.1-.5.5-1.4.5-2 0-.2-.2-.4-.4-.6-.5-1.6-1.5-3.2-3.1-4.8-4.6-.5-.6-.7-1.3-.2-1.9.5-.7 1.5-.9 2.2-.3.7.6 1.4 1.3 2.1 2 .3.2.5.5.8.7-.1 0 0 0 0 0zM8 17H1.5c-.7 0-1.4-.5-1.5-1.2-.1-.8.4-1.4 1.1-1.6h13.2c.8 0 1.4.4 1.6 1.1.3.9-.4 1.8-1.4 1.8-2.2-.1-4.3-.1-6.5-.1z" />
    </symbol>
    <symbol id="edit" viewBox="8.7 8.1 15.3 15.4">
        <path d="M24 11.5c-.1.9-.4 1.6-1.1 2.3l-8.1 8.1c-.4.5-.9.7-1.5.8-1.2.2-2.4.5-3.6.7-.6.1-1.1-.3-1-1 .3-1.5.6-3 .9-4.4 0-.2.2-.4.3-.5l8.4-8.4c1.9-1.9 4.9-1.1 5.6 1.5.1.3.1.6.1.9zm-9.8 8.6l.3-.3c1.2-1.2 2.5-2.4 3.7-3.7l3.6-3.6c.9-.9.7-2.3-.5-2.7-.7-.3-1.4-.1-1.9.5l-7.3 7.3-.2.2c1.1.5 1.9 1.2 2.3 2.3zm-1 .8c-.2-1.1-1-2-2.1-2.1-.1.5-.2 1-.3 1.4l.2-.2c.3.3.6.7 1 1.1.3 0 .7-.1 1.2-.2z" />
    </symbol>
    <symbol id="facebook" viewBox="10 1.7 13 30.3">
        <path d="M20.3 7.6H23V1.7h-4.3c-4.6 0-5.8 3.9-5.8 6.4v3.7H10v4.3h2.9V32h5.8V16.1h4.2l.1-4.3h-4.3V8.4c0-1.2 1.1-.8 1.6-.8z" />
    </symbol>
    <symbol id="googleplus" viewBox="0 0 100 100">
        <path d="M64.204 1.587H41.112c-10.29 0-17.413 2.256-23.824 7.552-5.042 4.35-8.05 10.67-8.05 16.91 0 9.615 7.33 19.832 20.912 19.832 1.306 0 2.752-.134 4.028-.253l-.188.456c-.546 1.308-1.063 2.542-1.063 4.468 0 3.75 1.81 6.063 3.558 8.3l.22.282-.39.027c-5.61.384-16.05 1.1-23.676 5.787C3.63 70.306 2.93 78.095 2.93 80.354c0 8.99 8.376 18.06 27.09 18.06 21.76 0 33.146-12.005 33.146-23.863.003-8.77-5.14-13.1-10.6-17.697l-4.604-3.582c-1.423-1.178-3.195-2.645-3.195-5.364 0-2.672 1.77-4.436 3.335-5.992l.163-.165c4.973-3.918 10.61-8.36 10.61-17.965 0-9.658-6.036-14.65-8.937-17.048h7.664c.094 0 .187-.026.266-.077l6.6-4.15c.188-.12.276-.348.214-.562-.06-.214-.257-.36-.48-.36zM36.2 93.122c-13.263 0-22.175-6.195-22.175-15.416 0-6.02 3.645-10.396 10.824-12.997 5.748-1.936 13.17-2.032 13.243-2.032 1.257 0 1.89 0 2.893.126 9.28 6.605 13.743 10.073 13.743 16.678-.002 8.414-7.102 13.64-18.53 13.64zm-.124-50.78c-11.132 0-15.752-14.632-15.752-22.467 0-3.984.906-7.042 2.77-9.35 2.023-2.532 5.487-4.167 8.825-4.167 10.22 0 15.872 13.738 15.872 23.233 0 1.5 0 6.056-3.148 9.22-2.117 2.114-5.56 3.533-8.568 3.533zM96.57 46.81H84.4V34.685c0-.276-.223-.5-.5-.5h-5.234c-.276 0-.5.224-.5.5V46.81H66.06c-.276 0-.5.224-.5.5v5.304c0 .276.224.5.5.5h12.106v12.203c0 .276.224.5.5.5H83.9c.277 0 .5-.224.5-.5V53.113h12.17c.275 0 .5-.224.5-.5V47.31c0-.277-.224-.5-.5-.5z" />
    </symbol>
    <symbol id="graph" viewBox="237 312 38 34">
        <path d="M240 336h2c1.7 0 3 1.3 3 3v4c0 1.7-1.3 3-3 3h-2c-1.7 0-3-1.3-3-3v-4c0-1.7 1.3-3 3-3zM250 328h2c1.7 0 3 1.3 3 3v12c0 1.7-1.3 3-3 3h-2c-1.7 0-3-1.3-3-3v-12c0-1.7 1.3-3 3-3zM260 320h2c1.7 0 3 1.3 3 3v20c0 1.7-1.3 3-3 3h-2c-1.7 0-3-1.3-3-3v-20c0-1.7 1.3-3 3-3zM270 312h2c1.7 0 3 1.3 3 3v28c0 1.7-1.3 3-3 3h-2c-1.7 0-3-1.3-3-3v-28c0-1.7 1.3-3 3-3z" />
    </symbol>
    <symbol id="growth" viewBox="812 911 20 20">
        <path d="M822 911c-5.5 0-10 4.5-10 10s4.5 10 10 10 10-4.5 10-10-4.5-10-10-10zm6.1 10.7c-.4.7-1.4.9-2 .3-.7-.6-1.4-1.3-2-2-.2-.2-.4-.4-.6-.7h-.1v6.2c0 .6-.4 1.1-.9 1.3s-1.1.1-1.5-.4c-.3-.3-.4-.7-.4-1.1V919.2l-.2.2c-.8.8-1.5 1.6-2.3 2.3-.5.5-1 .6-1.6.3-.5-.2-.8-.7-.8-1.3 0-.3.1-.7.4-.9l5.1-5.1c.5-.5 1.3-.5 1.8 0 .2.2.4.3.5.5l4.4 4.4c.5.8.6 1.5.2 2.1z" />
    </symbol>
    <symbol id="hamburger" viewBox="0 0 14 12">
        <path fill-rule="evenodd" clip-rule="evenodd" d="M0 0h14v2H0V0zM0 10h14v2H0v-2zM0 5h14v2H0V5z" />
    </symbol>
    <symbol id="info" viewBox="12.7 8.2 6.8 15.4">
        <path d="M19.3 21.9l-.2.9c-.6.3-1.2.4-1.5.6-.4.1-.8.2-1.3.2-.8 0-1.4-.2-1.8-.6s-.6-.9-.6-1.5v-.7s.1-.5.2-.8l.8-2.9c.1-.3.1-.5.2-.8s-.1-.3-.1-.5c0-.4-.1-.6-.2-.8-.2-.1-.4-.2-.9-.2-.2 0-.4 0-.6.1-.3.1-.4.1-.6.2l.2-.9 1.5-.6s.9-.2 1.4-.2c.8 0 1.4.2 1.8.6.4.4.6.9.6 1.5v.7s-.1.5-.2.8l-.8 2.8c-.1.2-.1.5-.2.8v.6c0 .4.1.6.3.8s.5.2.9.2c.2 0 .4 0 .7-.1s.3-.1.4-.2zm.2-11.9c0 .5-.2.9-.6 1.3s-.8.5-1.4.5-1-.2-1.4-.5-.6-.8-.6-1.3.2-.9.6-1.3c.4-.4.8-.5 1.4-.5s1 .2 1.4.5.6.8.6 1.3z" />
    </symbol>
    <symbol id="instagram" viewBox="0 0 32 32">
        <path d="M25.9 3h-19C5.2 3 4 4.5 4 5.8v20.3C4 27.8 5.2 29 6.9 29h18.8c1.7 0 3.2-1.3 3.2-3V6c0-1.7-1.3-3-3-3zm-6 3.6c0-.4.3-.7.7-.7H25c.4 0 .7.3.7.7v4.3c0 .4-.3.7-.7.7h-4.3c-.4 0-.7-.3-.7-.7V6.6zm-3.1 4.7c2.8 0 5 2.2 5 5 0 2.7-2.2 5-5 5s-5-2.2-5-5 2.2-5 5-5zm9.3 14.8H7.5c-.4 0-.6-.2-.6-.6v-11h2.3c-.2 1.5-.3 1.2-.3 1.9 0 4.3 3.5 7.8 7.9 7.8 4.3 0 7.9-3.4 7.9-7.7 0-.7-.1-.5-.3-2h1.3v10.9c0 .5.8.7.4.7z" />
    </symbol>
    <symbol id="less" viewBox="9 15 13.9 2">
        <path d="M22.9 16.9L9 17v-2h13.9z" />
    </symbol>
    <symbol id="linkedin" viewBox="0 0 430.117 430.117">
        <path d="M430.117 261.543V420.56H337.93V272.193c0-37.27-13.335-62.707-46.704-62.707-25.473 0-40.632 17.142-47.3 33.724-2.433 5.928-3.06 14.18-3.06 22.477V420.56H148.65s1.242-251.285 0-277.32h92.21v39.31c-.187.293-.43.61-.606.895h.606v-.896c12.25-18.87 34.13-45.825 83.102-45.825 60.673 0 106.157 39.636 106.157 124.818zM52.183 9.558C20.635 9.558 0 30.25 0 57.463c0 26.62 20.038 47.94 50.96 47.94h.615c32.16 0 52.16-21.317 52.16-47.94-.607-27.212-20-47.905-51.552-47.905zM5.477 420.56H97.66V143.24H5.478v277.32z" />
    </symbol>
    <symbol id="livechat" viewBox="0 0 20 21">
        <!--<defs>
            <style>
                .cls-1 {
                    fill: #fff;
                }

                .cls-1, .cls-2 {
                    fill-rule: evenodd;
                }

                .cls-2 {
                    stroke: #fff;
                    stroke-width: 1px;
                    fill: none;
                }
            </style>
        </defs>-->
        <path d="M15.266 11.53c-.872 0-1.578-.698-1.578-1.56 0-.864.706-1.564 1.578-1.564.87 0 1.578.7 1.578 1.563 0 .862-.707 1.56-1.578 1.56zm-5.266 0c-.863 0-1.563-.698-1.563-1.56 0-.864.7-1.564 1.563-1.564s1.563.7 1.563 1.563c0 .862-.7 1.56-1.563 1.56zm-5.266 0c-.87 0-1.578-.698-1.578-1.56 0-.864.707-1.564 1.578-1.564.872 0 1.578.7 1.578 1.563 0 .862-.706 1.56-1.578 1.56z" class="cls-1" />
        <path d="M3.158 0h13.684C18.586 0 20 1.41 20 3.15v9.45c0 1.74-1.256 3.4-3 3.4H8s-5.944 5-5.895 5C.248 21 0 19.95 0 19.95V3.15C0 1.41 1.414 0 3.158 0z" class="cls-2" />
    </symbol>
    <symbol id="menu" viewBox="0 0 32 28">
        <path d="M0 0h32v4H0zM0 12h32v4H0zM0 24h32v4H0z" />
    </symbol>
    <symbol id="nb" viewBox="0 0 32 32">
        <path d="M26 2c.5 0 1 .5 1 1v21c0 .5-.5 1-1 1h-6v2.3l-2.9-1.9-.5-.4H5c-.5 0-1-.5-1-1V3c0-.5.5-1 1-1h21m0-2H5C3.4 0 2 1.4 2 3v21c0 1.6 1.4 3 3 3h11l6 4v-4h4c1.6 0 3-1.4 3-3V3c0-1.6-1.4-3-3-3zM9 11.6l-.8-1.4h-.1l.1 1.4V18h-1V8h.6l4.7 6.5.7 1.3h.1l-.2-1.3V8.2h1.1v10h-.6L9 11.6zm7.5-3.4h1.1v3.5h.1c.2-.3.5-.5.8-.6.3-.1.7-.2 1.1-.2.9 0 1.6.3 2 .9.5.6.7 1.5.7 2.7 0 1.2-.3 2.2-.9 2.8-.6.6-1.4 1-2.5 1-.5 0-1-.1-1.4-.2s-.7-.2-1-.4V8.2zm2.9 3.6c-.5 0-.8.1-1.1.4s-.5.6-.6 1.1v3.5c.2.1.4.2.6.2.3.1.5.1.8.1.6 0 1.1-.2 1.5-.7.4-.4.6-1.1.6-2.1 0-.4 0-.7-.1-1-.1-.3-.2-.6-.3-.8-.1-.2-.3-.4-.5-.5-.3-.1-.6-.2-.9-.2zm4.1 5.6c0-.3.1-.4.2-.6.1-.1.3-.2.6-.2s.5.1.6.2c.1.1.2.3.2.6 0 .2-.1.4-.2.6-.1.2-.3.2-.6.2-.2 0-.4-.1-.6-.2-.1-.2-.2-.4-.2-.6z" />
    </symbol>
    <symbol id="paper" viewBox="960 965 24 32">
        <path d="M981.3 971h-2.5c-.4 0-.8-.4-.8-.9v-2.2c0-1.6-1.2-2.9-2.8-2.9h-12.5c-1.5 0-2.7 1.3-2.7 2.9v26.2c0 1.6 1.2 2.9 2.7 2.9h18.5c1.5 0 2.8-1.3 2.8-2.9V973.9c0-1.6-1.2-2.9-2.7-2.9zm.7 23.1c0 .5-.3.9-.8.9h-18.5c-.4 0-.8-.4-.8-.9v-26.2c0-.5.3-.9.8-.9H975.3c.4 0 .8.4.8.9v2.2c0 1.6 1.2 2.9 2.8 2.9h2.5c.4 0 .8.4.8.9V994.1h-.2zM965 975h8c.6 0 1-.4 1-1s-.4-1-1-1h-8c-.6 0-1 .4-1 1s.4 1 1 1zM979 977h-14c-.6 0-1 .4-1 1s.4 1 1 1h14c.6 0 1-.4 1-1s-.4-1-1-1zM979 981h-14c-.6 0-1 .4-1 1s.4 1 1 1h14c.6 0 1-.4 1-1s-.4-1-1-1zM979 985h-14c-.6 0-1 .4-1 1s.4 1 1 1h14c.6 0 1-.4 1-1s-.4-1-1-1zM979 989h-14c-.6 0-1 .4-1 1s.4 1 1 1h14c.6 0 1-.4 1-1s-.4-1-1-1z" />
    </symbol>
    <symbol id="percent" viewBox="0 0 28.13 34.66">
        <path d="M0 6.42a6.16 6.16 0 0 1 1.9-4.55A6.34 6.34 0 0 1 6.53 0a6.17 6.17 0 0 1 4.53 1.88 6.19 6.19 0 0 1 1.88 4.54 6.38 6.38 0 0 1-1.88 4.6 6.08 6.08 0 0 1-4.53 1.94 6.31 6.31 0 0 1-4.62-1.9A6.3 6.3 0 0 1 0 6.42zm2.79 0a3.54 3.54 0 0 0 1.09 2.64 3.65 3.65 0 0 0 2.65 1.06 3.47 3.47 0 0 0 2.53-1.07 3.59 3.59 0 0 0 1.06-2.63A3.43 3.43 0 0 0 9.06 3.9a3.49 3.49 0 0 0-2.54-1.07 3.67 3.67 0 0 0-2.65 1.06 3.4 3.4 0 0 0-1.08 2.53zm1.73 27.29a.81.81 0 0 1 0-.88L20.96 1.01a.89.89 0 0 1 .82-.49h.77a.9.9 0 0 1 .81.42.82.82 0 0 1 0 .89L6.81 33.65a.84.84 0 0 1-.82.47h-.68a.87.87 0 0 1-.79-.41zm10.64-5.53a6.24 6.24 0 0 1 1.9-4.59 6.31 6.31 0 0 1 4.63-1.89 6.18 6.18 0 0 1 4.54 1.9 6.51 6.51 0 0 1 0 9.17 6.18 6.18 0 0 1-4.54 1.89 6.32 6.32 0 0 1-4.63-1.88 6.23 6.23 0 0 1-1.9-4.6zm2.79 0a3.55 3.55 0 0 0 1.11 2.59 3.64 3.64 0 0 0 2.66 1.06 3.51 3.51 0 0 0 2.57-1.07 3.56 3.56 0 0 0 1.08-2.62 3.44 3.44 0 0 0-1.09-2.53 3.52 3.52 0 0 0-2.56-1.07 3.65 3.65 0 0 0-2.66 1.06 3.42 3.42 0 0 0-1.11 2.54z" />
    </symbol>
    <symbol id="print" viewBox="0 0 24.998 24.998">
        <path d="M24.526 7.62H.51c-.204 0-.37.165-.37.37v9.303c0 .204.167.37.37.37H3.7v-4.2c0-.51.415-.924.924-.924h15.79c.508 0 .923.413.923.923v4.2h3.19c.203 0 .37-.166.37-.37V7.988c0-.203-.167-.368-.37-.368zM21.336 5.63h-1.11V1.11H4.81v4.52H3.7V.925c0-.51.415-.924.924-.924h15.79c.508 0 .923.414.923.924V5.63zM3.7 17.35v-4.2c0-.51.415-.924.924-.924h15.79c.508 0 .923.414.923.924V23.9c0 .51-.415.924-.924.924H4.623c-.508 0-.923-.414-.923-.924v-6.55m1.11 6.365h15.418V13.333H4.808v10.382zM6.44 14.858h8.49v1.108H6.44zM6.44 17.99h12.155v1.11H6.44zM6.44 21.122h12.155v1.108H6.44z" />
        <path fill="#fff" d="M23.492 11.057c0 .204-.166.37-.37.37h-1.97c-.205 0-.37-.166-.37-.37V9.5c0-.206.165-.37.37-.37h1.97c.204 0 .37.164.37.37v1.557z" />
    </symbol>
    <symbol id="refresh" viewBox="0 0 15 12.516">
        <g fill="#010202"><path d="M4.145.99C4.937.44 5.967.068 7.02.012c3.986-.208 6.68 2.302 6.533 5.744 0 0 .47-.504.656-.756.112-.126.364-.107.528-.036.108.043.252.186.262.347-.008.096-.03.164-.107.248l-1.4 1.524c-.113.127-.447.334-.723.034-.078-.062-.94-.946-1.365-1.363-.17-.152-.22-.35-.11-.517.107-.207.535-.34.705-.188.21.15.662.708.662.708-.027-3.03-2.346-4.805-5.294-4.71-.92.03-1.958.325-2.64.792-.305.167-.573-.025-.697-.21-.13-.19-.04-.528.115-.638zM10.842 11.538c-.795.55-1.826.917-2.88.968-3.985.197-6.672-2.323-6.512-5.764 0 0-.472.502-.66.754-.113.128-.365.106-.53.035C.155 7.488.01 7.344 0 7.184c.01-.096.032-.162.107-.247l1.407-1.52c.114-.127.447-.333.724-.032.078.062.935.95 1.36 1.368.168.152.22.35.108.518-.11.206-.537.337-.706.186-.21-.15-.66-.71-.66-.71.018 3.03 2.33 4.812 5.28 4.727.92-.026 1.958-.32 2.642-.784.305-.166.572.025.695.21.13.19.04.528-.115.638z" /></g>
    </symbol>
    <symbol id="save" viewBox="9 10 13 13">
        <path d="M9 10v10l3 3h10V10H9zm1 3v-2h2v2h-2zm10 9h-4v-3h-2v3h-2v-5h8v5z" />
    </symbol>
    <symbol id="send" viewBox="0 0 70.87 70.87">
        <path d="M20.088 46.35c-.03-.328.102-.65.357-.863l28.68-23.818-35.507 18.64c-.305.16-.67.146-.964-.025l7.273 16.4 6.055-6.57c-2.926-1.633-5.324-2.95-5.38-2.982-.29-.16-.482-.452-.514-.782zM38.877 57.06c-.748 0-1.564-.312-2.497-.95-2.252-1.54-15.643-8.903-15.778-8.978-.29-.16-.482-.45-.514-.78-.03-.33.102-.653.357-.865l28.68-23.818-35.507 18.64c-.32.167-.706.15-1.007-.046L1.997 33.407c-.968-.58-1.44-1.278-1.374-2.06.097-1.14 1.312-1.667 1.554-1.762.67-.243 64.78-23.462 65.644-23.793.504-.193.94-.288 1.335-.288.88 0 1.303.47 1.476.752.247.398.43 1.092-.093 2.137-.863 1.613-28.325 45.293-29.795 47.632-.228.418-.832 1.034-1.865 1.034zM22.85 46.087c3.46 1.91 12.73 7.05 14.66 8.37.79.542 1.22.6 1.367.6.085 0 .123-.018.13-.023 9.783-15.57 28.217-44.933 29.678-47.43-.046.016-.096.033-.148.054-.875.335-63.014 22.84-65.66 23.798-.03.013-.07.034-.112.058.068.054.162.12.287.193l10.153 6.557L56.61 15.48c.453-.24 1.014-.096 1.298.33.284.425.2.997-.193 1.324L22.85 46.088z" />
    </symbol>
    <symbol id="share" viewBox="0 0 20 20">
        <circle cx="16.425" cy="3.577" r="3.427" />
        <circle cx="16.425" cy="16.572" r="3.427" />
        <circle cx="3.507" cy="10.305" r="3.427" />
        <path d="M16.097 2.948L16.75 4.2 3.834 10.935 3.18 9.683zM3.815 9.67l12.92 6.265-.617 1.272-12.92-6.267z" />
    </symbol>
    <symbol id="shield" viewBox="138.1 796 10.9 11">
        <path d="M149 796.4v4.9c0 .8-.2 1.6-.6 2.3-.9 1.7-2.6 2.8-4.8 3.4h-.2c-2.9-.9-4.7-2.5-5.3-4.9v-5.7c3.6-.5 7.2-.5 10.9 0z" />
    </symbol>
    <symbol id="speech-dialog" viewBox="0 0 128 128">
        <path d="M116.5 28.1h-17V11c0-6.1-5.2-11-11.5-11H11.5C5.2 0 0 4.9 0 11v76.9c0 3.2 1.2 6.2 3.5 8.5s5.3 3.5 8.5 3.5 6.2-1.3 8.4-3.5l8.6-8.3c1.4 4.6 5.8 8 11 8h34.1c2.7 0 5.2 1 7.1 3l26.3 25.4c2.3 2.3 5.3 3.5 8.5 3.5s6.2-1.2 8.5-3.5 3.5-5.3 3.5-8.5V39.1c0-6-5.2-11-11.5-11zM14.8 90.7c-1.5 1.5-4.1 1.5-5.7 0C8.4 89.9 8 89 8 87.9V11c0-1.7 1.6-3 3.5-3H88c1.9 0 3.5 1.3 3.5 3v46c0 1.7-1.6 3-3.5 3H53.9c-4.8 0-9.3 1.9-12.7 5.2L14.8 90.7zM120 116c0 1.1-.4 2-1.2 2.8-1.6 1.5-4.1 1.6-5.7 0L86.8 93.4c-3.4-3.4-7.9-5.3-12.7-5.3H40c-1.9 0-3.5-1.3-3.5-3v-4.2l10.3-10c1.9-1.9 4.4-2.9 7.1-2.9H88c6.3 0 11.5-4.9 11.5-11V36.1h17c1.9 0 3.5 1.3 3.5 3V116zM50 48c3.3 0 6-2.7 6-6s-2.7-6-6-6-6 2.7-6 6 2.7 6 6 6zM26 36c-3.3 0-6 2.7-6 6s2.7 6 6 6 6-2.7 6-6-2.7-6-6-6zM74 48c3.3 0 6-2.7 6-6s-2.7-6-6-6-6 2.7-6 6 2.7 6 6 6z" />
    </symbol>
    <symbol id="stats" viewBox="862 309.9 44 36.2">
        <path d="M905.7 312c.4-.5.4-1.3-.2-1.8-.5-.4-1.3-.4-1.8.2l-5.4 6.5c-.2 0-.4-.1-.6-.1-2.1-.2-3.9 1.3-4.1 3.4 0 .4 0 .8.1 1.1l-5.1 5.2c-.5-.4-1.2-.7-1.9-.8-2-.2-3.8 1.2-4.1 3.2l-7.5 3.4c-.6-.9-1.6-1.6-2.8-1.7-2.1-.2-3.9 1.3-4.1 3.4-.1.8.1 1.6.5 2.2l-6.4 7.8c-.4.5-.4 1.3.2 1.8.2.2.4.2.7.3.4 0 .8-.1 1.1-.5l6.3-7.7c.3.1.6.2 1 .2 2 .2 3.8-1.2 4.1-3.2l7.5-3.4c.6.9 1.6 1.6 2.8 1.7 2.1.2 3.9-1.3 4.1-3.4 0-.4 0-.8-.1-1.1l5.1-5.2c.5.4 1.2.7 1.9.8 2.1.2 3.9-1.3 4.1-3.4.1-1-.2-1.8-.7-2.6l5.3-6.3zm-33.9 23.6c-.7-.1-1.2-.7-1.1-1.4.1-.7.7-1.2 1.4-1.1s1.2.7 1.1 1.4c-.1.6-.7 1.1-1.4 1.1zm14.5-4.9c-.7-.1-1.2-.7-1.1-1.4.1-.7.7-1.2 1.4-1.1s1.2.7 1.1 1.4-.7 1.2-1.4 1.1zm11-8.9c-.7-.1-1.2-.7-1.1-1.4.1-.7.7-1.2 1.4-1.1s1.2.7 1.1 1.4c-.1.7-.7 1.2-1.4 1.1z" />
    </symbol>
    <symbol id="tick" viewBox="714.8 1205.6 16.3 12.7">
        <path d="M721.3 1215.3c1.1-1.3 2.1-2.5 3.2-3.8 1.5-1.8 3-3.5 4.4-5.3.3-.4.7-.7 1.3-.5.9.2 1.2 1.2.6 2-.9 1.1-1.8 2.1-2.6 3.2-1.9 2.3-3.8 4.6-5.8 6.9-.6.7-1.4.8-2 .1-1.7-1.9-3.5-3.8-5.2-5.7-.5-.6-.5-1.3 0-1.7.5-.4 1.2-.4 1.7.1 1.4 1.5 2.8 3 4.1 4.5.2 0 .2.1.3.2z" />
    </symbol>
    <symbol id="transfer-in" viewBox="440 520 19.9 18.1">
        <path d="M441 525.2h1c.6 0 1.2.1 1.7.4.1.1.3.1.4.1.4 0 .7-.2.9-.5.2-.5 0-1-.4-1.3-.8-.4-1.7-.6-2.6-.6h-1c-.5 0-1 .4-1 .9 0 .6.4 1 1 1zM456.1 529.6c-.2-.2-.4-.2-.6-.3-.4 0-.8.2-.9.6-.2.4-.1.8.2 1.1.6.5 1.1 1.1 1.7 1.6l.2.2H451.7c-.6 0-1.2-.1-1.7-.4-.5-.2-1.1 0-1.3.4-.2.5 0 1 .4 1.3.8.4 1.7.6 2.6.6H456.5c-.2.1-.3.3-.5.4-.5.5-1 .9-1.4 1.4-.4.4-.3 1.1.2 1.4.4.3.9.2 1.3-.2 1.1-1 2.1-2 3.2-3 .1-.1.3-.2.4-.4.3-.4.3-.9 0-1.2-1.2-1.2-2.4-2.4-3.6-3.5zM451.7 525.3h4.8c-.2.1-.3.3-.5.4-.5.5-1 .9-1.4 1.4-.4.4-.3 1.1.2 1.4.4.3.9.2 1.3-.2 1.1-1 2.1-2 3.2-3 .1-.1.3-.2.4-.4.3-.4.3-.9 0-1.2-1.2-1.1-2.4-2.3-3.6-3.4-.2-.2-.4-.2-.6-.3-.4 0-.8.2-.9.6-.2.4-.1.8.2 1.1.6.5 1.1 1.1 1.7 1.6l.2.2H451.8c-3.2 0-5.9 2.5-5.9 5.7 0 2.1-1.7 3.8-3.9 3.8h-1c-.5 0-1 .4-1 .9s.4.9 1 .9h1c3.2 0 5.8-2.5 5.8-5.7 0-2.1 1.8-3.8 3.9-3.8z" />
    </symbol>
    <symbol id="twitter" viewBox="2 3.3 29 23.7">
        <path d="M31 6.1c-1.1.5-2.2.8-3.4.9 1.2-.7 2.2-1.9 2.6-3.3-1.2.8-2.4 1.3-3.8 1.5C25.3 4 23.8 3.3 22 3.3c-3.3 0-6 2.7-6 6 0 .5.1.9.2 1.4-5-.2-9.4-2.6-12.3-6.2-.5.9-.8 1.9-.8 3 0 2.1 1.1 3.9 2.7 5-1 0-1.9-.3-2.7-.7v.1c0 2.9 2.1 5.3 4.8 5.9-.5.1-1 .2-1.6.2-.4 0-.8 0-1.1-.1.8 2.4 3 4.1 5.6 4.1-2 1.6-4.6 2.6-7.4 2.6-.5 0-1 0-1.4-.1C4.5 26 7.7 27 11 27c11 0 17-9.1 17-17v-.8c1.2-.8 2.2-1.9 3-3.1z" />
    </symbol>
    <symbol id="user" viewBox="0 0 28 28">
        <path d="M12.7 19.3c-3.6 0-6.6-3.6-6.6-8 0-2.1.7-4.1 1.9-5.6 1.2-1.6 2.9-2.4 4.7-2.4 3.6 0 6.6 3.6 6.6 8-.1 4.4-3 8-6.6 8zm0-14.3C10 5 7.9 7.8 7.9 11.3c0 3.4 2.2 6.2 4.8 6.2 2.7 0 4.8-2.8 4.8-6.2 0-3.5-2.2-6.3-4.8-6.3zM20.2 28H2.4C1.1 28 0 26.9 0 25.6c0-4 3.2-7.2 7.2-7.2.5 0 .9.4.9.9s-.4.9-.9.9c-3 0-5.4 2.4-5.4 5.4 0 .4.3.7.7.7H23c.4 0 .7-.3.7-.7 0-3-2.4-5.4-5.4-5.4-.5 0-.9-.4-.9-.9s.4-.9.9-.9c4 0 7.2 3.2 7.2 7.2 0 1.4-1.1 2.4-2.5 2.4h-2.8zM20.8 10.9h-.2c-.5-.1-.8-.6-.7-1.1.1-.6.2-1.2.2-1.8 0-3.4-2.2-6.2-4.8-6.2-.7 0-1.4.2-2 .6-.4.2-1 .1-1.2-.3-.2-.4-.1-1 .3-1.2.9-.6 1.9-.9 2.9-.9 3.6 0 6.6 3.6 6.6 8 0 .8-.1 1.5-.3 2.2-.1.4-.4.7-.8.7zM27 23.6c-.1 0-.2 0-.4-.1-.4-.2-.6-.7-.4-1.2 0-.1.1-.2.1-.3 0-3-2.3-5.5-5.2-5.5-.5 0-.9-.4-.9-.9s.4-.9.9-.9c4 0 7 3.3 7 7.2 0 .3-.1.7-.2 1-.3.5-.6.7-.9.7z" />
    </symbol>
    <symbol id="withdraw" viewBox="315 519 16 17.1">
        <path d="M324.5 524.1v6.5c0 .6-.4 1.2-1 1.4s-1.3.1-1.7-.4c-.3-.3-.4-.7-.4-1.1v-6.4c-.1.1-.2.2-.3.2-.9.8-1.7 1.6-2.6 2.4-.5.5-1.1.6-1.7.3-.6-.2-.9-.8-.9-1.4 0-.4.1-.7.4-.9 1.9-1.8 3.7-3.5 5.6-5.3.5-.5 1.4-.5 2-.1l.6.6c1.6 1.6 3.3 3.1 4.9 4.7.6.6.7 1.3.3 1.9-.5.7-1.5.9-2.2.3-.8-.7-1.5-1.4-2.2-2.1-.2-.2-.5-.4-.8-.6.1-.1.1 0 0 0zM323 536h-6.5c-.7 0-1.4-.5-1.5-1.2-.1-.8.4-1.4 1.1-1.6h13.2c.8 0 1.4.4 1.6 1.1.3.9-.4 1.8-1.4 1.8-2.2-.1-4.3-.1-6.5-.1z" />
    </symbol>
</svg>

    <div id="siteContent" class="site__content">
            <div class="fullscreen-bg" style="background-image: url(https://invest.wealthify.com/assets/images/homepage-3.jpg)"></div>
        <div class="site__scene site__scene--fadein">


<!--- MAIN SITE CONTENT -->
<main class="site grid">
    <h1 data-heading="h1">Create your plan</h1>
    <s:set var="plan"><%=request.getParameter("plan")%></s:set>

    <s:form action="estimate">
        <s:hidden name="plan" value="%{#plan}"/>
        <s:textfield label="Upfront investment" key="upfrontInvestment" value="1000" size="70"/>
        <s:textfield label="SIP per month" key="sip" value="500" size="70"/>
        <s:textfield label="Years" key="years" value="5" size="70"/>
        <s:radio label="Risk Category" name="riskCategory" list="#{'1':'Cautious','2':'Tentative','3':'Confident','4':'Ambitious','5':'Adventurous'}" value="1" />
        <s:submit/>
    </s:form>
</main>
<!-- /SITE CONTENT -->
        </div>
    </div>

    <div id="sessionCountdownDialog" data-js="session-countdown" class="modal-dialog session-countdown">
        <div data-row class="text--center">
            <h2 data-heading="h2">Are you still there?</h2>
            <p>Your session will expire in:</p>
            <div data-js="session-countdown-timer" class="timer"></div>
            <div data-columns="1/2">
                <button type="button" data-js="refresh-session" data-button="bright full">
                    <span>
                        I'm still here!
                    </span>
                </button>
            </div>
            <div data-columns="1/2 last">
                <button type="button" data-js="abandon-session" data-button="mid full">
                    Get me outta here...
                </button>
            </div>
        </div>
    </div>
    <!-- end of modal-dialog -->


                <script>
                    window.assetsPath = '//invest.wealthify.com/assets/';
                    window.appPath = 'https://invest.wealthify.com/';
                </script>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="https://invest.wealthify.com/assets/js/vendor/jquery-1.11.1.js"><\/script>')</script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
    <script>window.jQuery.ui || document.write('<script src="https://invest.wealthify.com/assets/js/vendor/jquery-ui.min.js"><\/script>');</script>
    <script src="https://invest.wealthify.com/assets/js/vendor/jquery.unobtrusive-ajax.min.js"></script>
    <script src="https://invest.wealthify.com/assets/js/vendor/jquery.validate.min.js"></script>
    <script src="https://invest.wealthify.com/assets/js/vendor/jquery.validate.unobtrusive.min.js"></script>
    <script src="https://invest.wealthify.com/assets/js/vendor/moment.min.js"></script>
    <script src="https://invest.wealthify.com/assets/js/vendor/jquery.smoothState.min.js"></script>
    <script src="https://invest.wealthify.com/assets/js/scripts.min.js"></script>





</body>
</html>