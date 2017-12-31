
<!DOCTYPE html>
<html lang='en'>
  <head>
  <meta charset="utf-8">

  <title>
    Nutmeg
  </title>

  <!-- Sets initial viewport load  -->
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />

  <!-- Makes your prototype chrome-less once bookmarked to your phone's home screen -->
  <meta name="apple-mobile-web-app-capable" content="yes" />
  <meta name="apple-mobile-web-app-status-bar-style" content="black">

  <meta name="csrf-param" content="authenticity_token" />
<meta name="csrf-token" content="sHfgKbbQYZ13hJ4WSK5DIGzePDie4yR70TVeg7rdMopimuOINyTC8O4WaLXlGjvC+VAJFIDfyiYdnAtUg6lXtA==" />

  <!-- cloud typography -->
  <link rel="stylesheet" media="screen" href="//cloud.typography.com/7703754/792368/css/fonts.css" />


  <!-- Optimizely -->
<script type="text/javascript" src="//cdn.optimizely.com/js/148585023.js"></script>


  <!-- Start of nutmeg Zendesk Widget script -->
<script>/*<![CDATA[*/window.zEmbed||function(e,t){var n,o,d,i,s,a=[],r=document.createElement("iframe");window.zEmbed=function(){a.push(arguments)},window.zE=window.zE||window.zEmbed,r.src="javascript:false",r.title="",r.role="presentation",(r.frameElement||r).style.cssText="display: none",d=document.getElementsByTagName("script"),d=d[d.length-1],d.parentNode.insertBefore(r,d),i=r.contentWindow,s=i.document;try{o=s}catch(e){n=document.domain,r.src='javascript:var d=document.open();d.domain="'+n+'";void(0);',o=s}o.open()._l=function(){var e=this.createElement("script");n&&(this.domain=n),e.id="js-iframe-async",e.src="https://assets.zendesk.com/embeddable_framework/main.js",this.t=+new Date,this.zendeskHost="nutmeg.zendesk.com",this.zEQueue=a,this.body.appendChild(e)},o.write('<body onload="document._l();">'),o.close()}();
/*]]>*/</script>
<!-- End of nutmeg Zendesk Widget script -->

<script>
  zE(function() {
    zE.hide();
  });

  window.zESettings = {
    webWidget: {
      position: {
        horizontal: 'right',
        vertical: 'top'
      }
    }
  };
</script>


  

  

  <!-- Identifies our site to Google for Google Analytics -->
  <meta name="google-site-verification" content="TJbX87rxjKJFjqnw_dNMQkvgvsRD8FTI4Rw7j2oxL3s" />

  <script src="https://app.nutmeg.com/client/assets/onboarding_v2016-55da6bc479c5f8e4d6bd80cd725d2e74cb5431cc22443e5b20c749ca6183daaa.js"></script>

  <link rel="stylesheet" media="screen" href="https://app.nutmeg.com/client/assets/2015_refresh-fc56e32fdb5e972c6544e8e719be4122946274c20f7da8baf9c9a4e916a8d3c4.css" />
  <link rel="stylesheet" media="screen" href="https://app.nutmeg.com/client/assets/onboarding_v2016-f5499a0d30ce35097fb6d382218abc063ef9f433a719abda3d7fce73c217608d.css" />

  <script type="text/javascript">
    var nutmeg = {
      settings: {
        featureFlagLisaAccount: true
      }
    };
  </script>
</head>


  <body class=" white-bg">
    <!-- Google Tag Manager -->
    <noscript>
  <iframe src="//www.googletagmanager.com/ns.html?id=GTM-WKFP3X" height="0" width="0" style="display:none;visibility:hidden"></iframe>
</noscript>

<script>
  (function(w,d,s,l,i){
    w[l]=w[l] ||[];
    w[l].push({
      'gtm.start': new Date().getTime(),
      event:'gtm.js'
    });

    var f=d.getElementsByTagName(s)[0], j=d.createElement(s), dl=l!='dataLayer'?'&l='+l:'';

    j.async=true;

    j.src='//www.googletagmanager.com/gtm.js?id='+i+dl;

    f.parentNode.insertBefore(j,f);
  })

  (window,document,'script','dataLayer','GTM-WKFP3X');
</script>
<!-- End Google Tag Manager -->


    <div>
    <nav class="navbar navbar-default navbar-fixed-top onboarding no-bottom-border">
      <div class="progress-stripe">
        <div class="progress-bar" style="width: 15%;"></div>
      </div>
      <div class="container-fluid" style="text-align: center;">
        <ul class="nav navbar-nav navbar-left">
          <li>
            <a style="padding-left: 0px;" href="https://www.nutmeg.com">
              <img class="logo" src="/client/assets/Nutmeg_Logo_green-7342ce576fb32004a6b496c7a8e828072d72c2204e4541899b3ca7cdadb29b53.png" alt="Nutmeg logo green" />
            </a>
          </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li>
            <a target="_blank" href="//support.nutmeg.com/hc/en-us/"> <span class='circle-icon'>?</span> </a>
          </li>
          <li>
            <a class="text-link" href="tel:020 3598 1515">
              <i class="fa fa-phone"></i><span class='phone-number'> 020 3598 1515</span>
</a>          </li>
        </ul>
        <div class="clearfix"></div>
      </div>
    </nav>
</div>


    <script>
  var domVariables = {
    formToken: '/pFHAc3qRHQUTUXJ/vMFkr4qQt4OQpBtiWvv400+tv8sfESgTB7nGY3fs2pTR31wK6R38hB+fjBFwro0dErTwQ==',
    action: 'try_it_out',
    urlParams: {"controller":"onboarding/v2016","action":"try_it_out"},
    signUpPath: '/client/sign-up/new'
  }
</script>

<div ng-app="app.onboardingV2016.tryItOut" ng-cloak>

  <div ng-controller="TryItOutController as ctrl">

    <div ng-if="ctrl.showSettingsBar()">
      <div class="settings-bar" ng-class="ctrl.isPastStep('pot_details') ? 'two-row' : ''">

  <div class="container-fluid">

    <div class="row tight-gutter-10">
      <div class="col-sm-3">
        <div class="row settings left-settings" ng-class="ctrl.stepDone('pot_details') ? 'border-bottom' : ''">

          <div class="col-xs-12">
            <div class="setting-step {{ ctrl.pot.accountType }}"
                 ng-click="ctrl.editOption('pot_details')"
                 ng-class="
                 {
                   untouched: ctrl.isBeforeStep('pot_details'),
                   active: ctrl.isCurrentStep('pot_details'),
                   done: ctrl.stepDone('pot_details')
                 }">
              <p id="settings-step-pot-name" class="figure">{{ ctrl.pot.name }}</p>

              <span id="settings-step-pot-goal" class="label goal-name">
                {{ ctrl.formattedGoalName() }}
                <span ng-if="ctrl.pot.target > 0">  - {{ ctrl.pot.target | poundCurrency }}</span>
                <span ng-if="ctrl.pot.target == 0"> - No target set</span>
              </span>
              <div class="down-triangle"></div>
            </div>
          </div>

        </div>
      </div>

      <div class="col-sm-9 col-lg-6 col-lg-offset-3">
        <div class="row settings right-settings" ng-class="ctrl.isBeforeStep('timeframe') ? 'hidden-xs' : ''">

          <div class="setting-step-container" ng-style="ctrl.isFourSettings() && {'width': ctrl.getSettingsBarItemsWidth()}">
            <div class="setting-step setting-step-timeframe"
                 ng-click="ctrl.editOption('timeframe')"
                 ng-class="{
                   untouched: ctrl.isBeforeStep('timeframe'),
                   active: ctrl.isCurrentStep('timeframe'),
                   done: ctrl.isTimeframeSubmitted()
                 }">
              <div class="figure text-center">
                <span ng-if="ctrl.pot.timeframe == 0">None</span>
                <span ng-if="ctrl.pot.timeframe > 0">{{ ctrl.pot.timeframe }}<span class="suffix">yrs</span></span>
              </div>

              <span class="label text-center">
                Timeframe
              </span>
              <div class="down-triangle"></div>
            </div>
          </div>

          <div class="setting-step-container" ng-hide="ctrl.shouldDisplaySettingStep()" ng-style="ctrl.isFourSettings() && {'width': ctrl.getSettingsBarItemsWidth()}" style="width: 40%;">
            <div class="setting-step setting-step-contributions"
                 ng-click="ctrl.isTimeframeSubmitted() && ctrl.editOption('contributions')"
                 ng-class="
                 {
                   untouched: ctrl.isBeforeStep('contributions'),
                   active: ctrl.isCurrentStep('contributions'),
                   done: ctrl.isContributionsSubmitted()
                 }"
                 id="pot_contributions_tab">
              <div class="row tight-gutter-10">
                <div ng-class="ctrl.isLisaAccount() ? 'col-xs-12' : 'col-xs-6'"
                     style="padding-left: 0px;"
                     ng-if="ctrl.shouldDisplayStartingAmount()">
                  <div class="figure text-center">
                    {{ ctrl.pot.contributions.starting | poundCurrency }}
                  </div>
                  <span class="label text-center">
                    Starting
                  </span>
                </div>
                <div ng-class="ctrl.shouldDisplayStartingAmount() ? 'col-xs-6' : 'col-xs-12'"
                     ng-if="!ctrl.isLisaAccount()"
                     style="padding-right: 0px;">
                  <div class="figure text-center">
                    {{ ctrl.pot.contributions.monthly | poundCurrency }}
                  </div>
                  <span class="label text-center">
                    Monthly
                  </span>
                </div>
              </div>
              <div class="down-triangle"></div>
            </div>
          </div>

          <div class="setting-step-container" ng-style="ctrl.isFourSettings() && {'width': ctrl.getSettingsBarItemsWidth()}">
            <div class="setting-step"
                 ng-click="ctrl.isContributionsSubmitted() && ctrl.editOption('investment_style')"
                 ng-class="
                 {
                   untouched: ctrl.isBeforeStep('investment_style'),
                   active: ctrl.isCurrentStep('investment_style'),
                   done: ctrl.shouldShowInvestmentStyleSelection()
                 }">
                 <div class="figure text-center" style="text-transform: capitalize;">
                   {{ ctrl.pot.investmentStyle }}
                 </div>

                 <span class="label text-center">
                   <span class="visible-lg-inline">Investment </span><span class="capitalize-except-lg">style</span>
                 </span>
                 <div class="down-triangle"></div>
            </div>
          </div>

          <div class="setting-step-container" ng-style="ctrl.isFourSettings() && {'width': ctrl.getSettingsBarItemsWidth()}">
            <div class="setting-step"
                 ng-click="ctrl.isInvestmentStyleSubmitted() && ctrl.editOption('risk')"
                 ng-class="
                 {
                   untouched: ctrl.isBeforeStep('risk'),
                   active: ctrl.isCurrentStep('risk'),
                   done: ctrl.isRiskLevelSubmitted()
                 }">
              <div class="figure text-center" ng-bind-html="ctrl.getInvestmentStyleShort()"></div>
              <span class="label text-center">
                Risk
              </span>
              <div class="down-triangle"></div>
            </div>
          </div>

        </div>
      </div>
    </div>

    <div class="clearfix"></div>

  </div>

</div>

    </div>

    <div ng-if="ctrl.isCurrentStep('email_capture')">
      <div class="container" ng-controller="EmailCaptureController as emailCtrl">

  <br>
  <br class="hidden-xs">
  <h1 id="email-capture-title" class="text-center">See the portfolio <br class="visible-xs">we'll build for you</h1>
  <br>
  <br>

  <div class="row">
    <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4">

      <div style="width: 300px; margin: 0 auto;">
        <form name="emailCaptureForm" novalidate>
          <h3 class="caps above-field">Enter email to start</h3>

          <div id="invalid-email-address-error" ng-if="!emailCtrl.validEmail()" class="alert alert-danger">
            Please enter a valid email address.
          </div>

          <div class="form-group label-inside icon-only no-mobile-stretch single-line-mobile">
            <label for="email_capture"><i class="fa fa-envelope"></i></label>
            <input id="email_capture" class="form-control standalone" autocomplete="off"
                   ng-pattern="ctrl.validEmailPattern"
                   ng-model="emailCtrl.data.email" required name="email"
                   type="text" placeholder="Email address" />
          </div>

          <div ng-if="emailCtrl.existingUser" class="alert alert-danger">
            This email has already been taken. Perhaps you meant to <a id="login_link" href="/auth/users/sign_in">Sign In</a> ?
          </div>
          <div ng-if="emailCtrl.authError" class="alert alert-danger">
            Something went wrong, please try again later.
          </div>

          <button class="btn btn-primary btn-block" style="margin-top: 10px;"
                  ng-click="emailCtrl.submitEmailCapture()"
                  ng-disabled="emailCtrl.httpRequesting"
                  id="submit_email_capture">
            {{ emailCtrl.httpRequesting ? 'Working...' : 'Continue' }}
          </button>

          <br>

          <p class="text-center diminished">We'll keep you posted about Nutmeg.</p>
        </form>
      </div>

    </div>
  </div>

</div>

    </div>

    <form name="potForm">
      <div ng-if="ctrl.isCurrentStep('account_type')">
        <div class="container account-type">

  <br>
  <br class="hidden-xs">
  <h1 id="choose-account-type-header" class="text-center max-270">Choose an account type to start with</h1>
  <br>

  <div class="row">
    <div class="col-xs-12 col-md-10 col-md-offset-1">
        <div class="row">
          <p class="text-center">
            <a ng-click="ctrl.openAccountTypeHelpModal()">Need help deciding?</a>
            <br>
            <br>
          </p>
        </div>
        <div class="row">
          <div class="col-sm-4">
            <a id="select_isa_btn" ng-click="ctrl.openAccountTypeModal('isa')"
              class="panel panel-default account-type-panel text-center">
              <div class="panel-body">
                <h3 class="text-center">Stocks &amp; Shares ISA</h3>
                <br>
                <p>The most flexible tax-advantaged account</p>
                <br>
                <span id="account_type_isa"
                   class="btn btn-primary" style="width:160px">
                  Select ISA
                </span>
              </div>
            </a>
          </div>
          <div class="col-sm-4">
            <a id="select_lisa_btn" ng-click="ctrl.openAccountTypeModal('lisa')"
              class="panel panel-default account-type-panel text-center">
              <div class="panel-body">
                <h3 class="text-center">Lifetime ISA</h3>
                <br>
                <p>Get up to a £1,000 bonus per year for your first home or retirement</p>
                <br>
                <span id="account_type_lisa"
                   class="btn btn-primary" style="width:160px">
                  Select LISA
                </span>
              </div>
            </a>
          </div>
          <div class="col-sm-4 hidden-xs">
            <a id="select_pension_btn" href="{{ ctrl.pensionSignUpUrl() }}"
              class="panel panel-default account-type-panel text-center">
              <div class="panel-body">
                <h3 class="text-center">Personal Pension</h3>
                <br>
                <p>An easy-to-use, intelligent personal pension</p>
                <br>
                <span id="account_type_pension"
                   class="btn btn-primary" style="width:160px">
                  Select Pension
                </span>
              </div>
            </a>
          </div>
        </div>

      <div class="row">


        <div class="col-sm-12 visible-xs text-center" style="padding: 40px 0 0;">
          Looking for a pension? <br>
          Come back on a tablet or desktop.
        </div>

      </div>

      <br>

      <p class="text-center">
        <a href="javascript:void(0)" class="gia"
           id="account_type_gia"
           ng-click="ctrl.selectAccountType('standard')">
          I want a general investment account
        </a>
      </p>

      <br><br>

    </div>
  </div>

</div>

<script type="text/ng-template" id="account_type_help_modal.html">
  <div class="modal-header">
  <h1>Need help deciding?</h1>
</div>
<div class="modal-body">

  <p>
    <strong>A stocks and shares ISA may be a good choice if…</strong><br>
    You want to invest up to £20,000/year and get tax-free returns while keeping the flexibility of withdrawing if and when you need to.
  </p>

  <p>
    <strong>A Lifetime ISA may be a good choice if…</strong><br>
    You are saving towards buying your first home up to £450,000 in the UK or for your retirement. You’ll get a 25% government bonus on what you pay in, as well as the flexibility of investing towards each of these major life goals. You can also withdraw for other purposes, though you will usually pay a hefty 25% government penalty on your withdrawal. If you are saving just for retirement however, a pension may be a better option.
  </p>

  <p>
    <strong>A pension may be a good choice if…</strong><br>
    You are saving for retirement and want a tax-efficient investment designed just for this purpose. Eligible contributions receive an instant 25% top-up and higher and additional rate taxpayers can claim back more on their tax returns. You can grow your pension automatically by Direct Debit, or have your employer pay in directly.
  </p>

  <p>
    <strong>For retirement, choosing between a Lifetime ISA and a Pension can get complicated</strong><br>
    Lifetime ISAs and Pensions both have benefits, but different rules and tax treatments. Which one is right for you will depend on your circumstances. <a href="https://www.nutmeg.com/lifetime-isa/lifetime-isa-saving-for-retirement" target="_blank">See our comparison guide for details</a>, and if you are still unsure, seek independent financial advice.
  </p>

  <p>
    <strong>A general investment account may be a good choice if…</strong><br>
    You are not investing for retirement or your first home, you already have a stocks and shares ISA elsewhere, you are ineligible to open an ISA, or you want to invest beyond the £20,000/year ISA limit.
  </p>

</div>

<div class="modal-footer">
  <a href="javascript:void(0)" ng-click="ctrl.closeModal()" class="btn btn-default btn-block">
    OK
  </a>
</div>

</script>

<script type="text/ng-template" id="account_type_single_modal.html">
  <div class="modal-header">
  <h1 ng-if="ctrl.accountType == 'isa'" class="account_type_modal_title text-center">Stocks &amp; Shares ISA</h1>
  <p ng-if="ctrl.accountType == 'lisa'" class="text-center">Stocks &amp; Shares</p>
  <h1 ng-if="ctrl.accountType == 'lisa'" class="account_type_modal_title text-center">Lifetime ISA</h1>
  <a id="close-popup-btn"
    href="javascript:void(0)"
    ng-click="ctrl.closeModal();">
    <i class="fa fa-close"></i>
  </a>
</div>

<div class="modal-body">

  <div ng-if="ctrl.accountType == 'isa'">
    <div class="center-block" style="max-width: 400px;">
      <ul class="fa-ul">
        <li><i class="fa fa-li fa-check"></i> Pay in up to £20,000 this tax year</li>
        <li><i class="fa fa-li fa-check"></i> Tax free returns now and in the future</li>
        <li><i class="fa fa-li fa-check"></i> Withdraw anytime for maximum flexibility</li>
        <li><i class="fa fa-li fa-check"></i> Transfer any cash or stocks and shares ISA to us</li>
        <li><i class="fa fa-li fa-check"></i> £500 starting + £100/month minimum investment</li>
      </ul>
    </div>
  </div>

  <div ng-if="ctrl.accountType == 'lisa'" class="lisa-summary-content">

    <div class="row text-center">
      <div class="col-sm-4">
        <h3>25% government bonus</h3>
        <p>For every £4 you invest, get a £1 bonus, up to £1,000/year.</p>
      </div>

      <div class="col-sm-4">
        <h3>First home or retirement</h3>
        <p>Use for your 1st home up to £450,000 or withdraw tax-free after age 60.</p>
      </div>

      <div class="col-sm-4">
        <h3>Save tax</h3>
        <p>Contribute up to £4,000 each tax year without paying tax on future returns.</p>
      </div>
    </div>

    <br>

    <div class="row text-center">
      <h3 class="caps" style="margin-bottom: 0;">What you'll need to get started</h3>
      <ul class="what-you-need fa-ul">
        <li><i class="fa fa-li fa-check"></i> UK tax resident between 18 and 39</li>
        <li><i class="fa fa-li fa-check"></i> £100 minimum</li>
        <li><i class="fa fa-li fa-check"></i> You expect to invest for at least 3 years</li>
      </ul>
    </div>

    <br>

    <div class="well traditional">
      <p class="text-center">
        <a id="lisa-key-feats-link" target="_blank" href="http://resources.nutmeg.com/Nutmeg-Lifetime-ISA-Information-Pack.pdf">
          <strong><i class="fa fa fa-file-pdf-o" aria-hidden="true"></i> Read the Lifetime ISA Information Pack</strong>
        </a>
      </p>
      <hr>
      <div class="row">
        <div class="col-sm-6">
          <p><strong>A Lifetime ISA may not be right for everyone</strong></p>
          <ul>
            <li>For retirement, you may be better off contributing to a pension. If you are unsure if a Lifetime ISA is right for you, please seek independent financial advice.</li>
            <li>Opting out of a workplace pension to pay into a Lifetime ISA means you may lose employer-matched contributions. Your entitlement to means-tested benefits may also be affected.</li>
            <li>As with all investing, your capital is at risk. Tax rules may change in the future.</li>
          </ul>
        </div>

        <br class="visible-xs" />

        <div class="col-sm-6">
          <p><strong>Things to know</strong></p>
          <ul>
            <li>The government bonus for your first year’s contributions will be paid after 5th April 2018. After that, you’ll get it monthly.</li>
            <li>You can withdraw without penalty before 6 April 2018.</li>
            <li>You must have held your Lifetime ISA for at least 12 months before you can use it towards your first home, which must be in the UK.</li>
            <li>You can continue to pay in to a Lifetime ISA until you reach the age of 50.</li>
          </ul>
        </div>
      </div>
      <hr>
      <p class="text-center"><strong>Withdrawals before age 60, and not for your first home, usually have a 25% government penalty so you may get back less than you put in.</strong></p>
    </div>
  </div>

  <br>

  <div class="alert alert-danger" ng-show="ctrl.showIncorrectAgeMessage" id="lisa_alert_invalid_age">
    You must be aged 18-39 to open a Lifetime ISA. <a class="other-account-types-link" href="javascript:void(0)" ng-click="ctrl.closeModal();">One of our other account types</a> might be more appropriate for you
  </div>

  <p class="text-center" ng-if="ctrl.accountType == 'lisa' && !ctrl.closeByRedirect()">Please enter your age to continue</p>

  <div class="input-group-btn">
    <p class="text-center">
      <br>
      <input ng-if="ctrl.accountType == 'lisa' && !ctrl.closeByRedirect()"
        type="text"
        class="form-control form-control-age"
        placeholder="Age (years)"
        style="border-top-right-radius: 0px; border-bottom-right-radius: 0px; border-color: #162b3b;"
        ng-model="ctrl.account.age"
        ng-change="ctrl.ageInputChange()">

      <a id="start-acctype-card-btn"
        href="javascript:void(0)"
        class="btn btn-primary"
        style="width:160px; border-top-left-radius: 0px; border-bottom-left-radius: 0px;"
        ng-click="ctrl.submitModal();">Continue</a>
      <br>
      <br>
      <a ng-if="!ctrl.closeByRedirect()" id="close-acctype-card-btn"
        href="javascript:void(0)"
        ng-click="ctrl.closeModal();">Go back and choose another account type</a>
    </p>
  </div>

</div>

</script>

      </div>

      <div ng-if="ctrl.isCurrentStep('pot_details')">
        <div class="container pot-details">

  <br>
  <br class="hidden-xs">
  <h1 id="goal-title" class="text-center max-270">What are you saving for?</h1>
  <br>
  <br>

  <div class="row">
    <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">

      <div class="row" ng-if="!ctrl.shouldDisplayGoalTypes()">

        <div class="col-xs-6">
          <input id="just_invest" type="radio" ng-model="ctrl.pot.goalType"
                 value="just_invest"
                 ng-change="ctrl.updatePotName()" />
          <label id="just_invest_label" for="just_invest"
                 class="btn btn-radio no-icons btn-block">
            Just invest
          </label>
        </div>

        <div class="col-xs-6">
          <label id="have_a_goal_label" ng-click="ctrl.setGoalType(true);" class="btn btn-radio no-icons btn-block">
            I have a goal
          </label>
        </div>

      </div>

      <div ng-if="ctrl.shouldDisplayGoalTypes()">
        <div class="row">
          <div ng-repeat="goalType in ctrl.goalTypes">
            <div class="col-xs-6 col-md-4" style="margin-bottom: 20px;">
              <input id="{{ ctrl.formattedGoalLabel(goalType) }}" type="radio" ng-model="ctrl.pot.goalType"
                     value="{{ ctrl.formattedGoalLabel(goalType) }}"
                     ng-change="ctrl.updatePotName()" />
              <label id="{{ ctrl.formattedGoalLabel(goalType) }}_label" for="{{ ctrl.formattedGoalLabel(goalType) }}"
                     class="btn btn-radio no-icons btn-block">
                {{ goalType }}
              </label>
            </div>
          </div>
        </div>
      </div>

      <div ng-if="ctrl.shouldDisplayExtraDetails()">
        <br><br>

        <div class="form-group label-inside">
          <label for="pot_name">Name of pot</label>
          <input id="pot_name" type="text" class="form-control"
                 ng-change="ctrl.watchPotName()"
                 ng-model-options="{ updateOn: 'blur' }"
                 ng-model="ctrl.pot.name" name="pot_name" required />
        </div>

        <div class="form-group label-inside" ng-if="ctrl.displayTargetAmount()">
          <label for="target_amount" class="two-lines">Target amount <br> (optional)</label>
          <input id="target_amount" type="text" class="form-control"
                 ng-model="ctrl.pot.target" ui-money-mask="0" />
        </div>

        <br>

        <div class="text-center" ng-if="!ctrl.displayTargetAmount()">
          <a href="javascript:void(0)"
             ng-click="ctrl.addTargetAmount()">
            Add an optional target amount
          </a>
        </div>
      </div>

      <br class="visible-xs" />
      <br class="visible-xs" />
      <br><br>

      <button class="btn btn-primary btn-block pinned-bottom max-300"
              ng-if="ctrl.canContinue()"
              ng-click="ctrl.goToStep('timeframe')"
              ng-disabled="!ctrl.canSubmitPotDetails()"
              id="submit_goal_type">
        Continue
      </button>

      <button class="btn btn-primary btn-block pinned-bottom max-300"
              ng-click="ctrl.goToStep('risk')"
              ng-if="ctrl.isEditingOption()"
              ng-disabled="!ctrl.canSubmitPotDetails()"
              id="refresh_charts_goal_type">
        Review changes
      </button>

    </div>
  </div>

</div>

      </div>

      <div ng-if="ctrl.isCurrentStep('timeframe')">
        <div class="container timeframe">

  <br>
  <br class="hidden-xs">
  <h1 id="time-frame-title" class="text-center max-270">How many years do you plan to invest for?</h1>
  <br>
  <br>

  <div class="row">
    <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 col-lg-6 col-lg-offset-3">

      <div class="max-460-container">
        <div ng-if="!ctrl.pot.noTimeframe">
          <h3 class="caps text-center">The longer the better</h3>

          <div class="row">
            <div class="col-sm-8">
              <rzslider rz-slider-model="ctrl.pot.timeframe"
                        rz-slider-options="ctrl.sliders.timeframe"></rzslider>
            </div>
            <div class="col-sm-4">
              <div class="form-group">
                <input type="number" class="form-control standalone" id="timeframe"
                       name="timeframe"
                       ng-model="ctrl.pot.timeframe" positive
                       ng-change="ctrl.set(); ctrl.updateTimeframe() && ctrl.getRiskPreference()"
                       ng-model-options="{ updateOn: 'keyup', debounce: 300 }"
                       min="0" max="50" required />
              </div>
            </div>
          </div>

          <div class="clearfix"></div>

          <div ng-if="ctrl.timeframeSentence" class="text-center">
            <br>

            {{ ctrl.timeframeSentence }}
          </div>

          <br><br>
        </div>
        
        <input type="checkbox" id="no-timeframe"
               ng-model="ctrl.pot.noTimeframe"
               ng-change="ctrl.updateTimeframe()  && ctrl.getRiskPreference()"
               ng-if="ctrl.editingExistingPot && ctrl.hasNoTimeframe()" />
        <label ng-if="ctrl.editingExistingPot && ctrl.hasNoTimeframe()" for="no-timeframe" class="checkbox" id="no_timeframe_btn">
          I don't have a timeframe <small>(we'll assume 10+ years)</small>
        </label>

        <br>


        <div id="lisa-timeframe-note" ng-if="ctrl.pot.accountType == 'lisa'">
          <p class="text-center">
            If you’re saving for a home on a short timeframe (3-5 years), you should consider a cash Lifetime ISA.
            If you’re saving for retirement, your timeframe should take you until at least age 60 to avoid a 25% government penalty.
          </p>
        </div>

        <div id="timeframe-error" ng-if="ctrl.timeframeChanged && !ctrl.validTimeframe()" class="alert alert-danger">
          <p class="text-center">
            Our minimum suggested timeframe you should consider for investing is <strong>3 years</strong>.
            For shorter timeframes you should consider keeping your money as cash.
          </p>
        </div>

        <p id="timeframe-help" class="text-center">
          <a ng-click="ctrl.openTimeframeHelpModal()">Need help deciding?</a>
        </p>

        <br>

        <button class="btn btn-primary btn-block pinned-bottom max-300"
                ng-click="ctrl.submitTimeframe()"
                ng-disabled="!ctrl.validTimeframe()"
                ng-if="!ctrl.isEditingOption()"
                id="submit_timeframe">
          Continue
          <span ng-if="ctrl.validTimeframe() && !ctrl.pot.noTimeframe">with {{ctrl.pot.timeframe}} year timeframe</span>
        </button>

        <button class="btn btn-primary btn-block pinned-bottom max-300"
                ng-click="ctrl.goToStep('risk')"
                ng-disabled="!ctrl.validTimeframe()"
                ng-if="ctrl.isEditingOption()"
                id="refresh_charts_timeframe">
          Review changes
        </button>

        <div id="access-your-money-anytime" ng-if="ctrl.pot.accountType != 'lisa'">
          <p class="text-center">
            Access your money anytime, without exit fees.
          </p>
        </div>

        <br><br><br>

      </div>

    </div>
  </div>

</div>

<script type="text/ng-template" id="timeframe_help_modal.html">
  <div class="modal-header">
  <h1>When are you likely to use this money?</h1>
</div>
<div class="modal-body">
  <p>
    <strong>Why set a timeframe?</strong>
  </p>
  <p>
    We use your timeframe – the length of time you can leave your money invested and untouched – and attitude to risk to suggest a portfolio that we think is right for you.
  </p>
  <p>
    Generally, the sooner you need the money, the less risk you should take as, should the market fall, your investments will have less time to recover. Conversely, if you have a
    longer timeframe, you may be able to take more risk, as your investments will have more time to recover.
  </p>
  <p>
    We also use your timeframe to project how much money you might have in the future to help you plan any contributions and increase the chance of reaching a goal.
  </p>
  <br>
  <p>
    <strong>Choosing a timeframe for a goal</strong>
  </p>
  <p>
    The length of time you invest for should relate to your investment goal. Some goals may have a specific timeframe, such as buying a house or paying for university.
  </p>
  <p>
    If you have a general goal, such as achieving good returns or simply beating inflation, you may not have a specific date in mind. Even so, it can help to think about when
    you may need the money in broad terms. For example, can you leave it for 5, 10, or 20 years? At some point you will want to make use of the money – the more you can think
    through when this may be, the better chance of an investing outcome and journey that suits you.
  </p>
  <p>
    Remember that you can access the money anytime without exit fees. However, if you do dip in early, bear in mind that you’ll have a greater chance of experiencing losses.
    <a href="https://www.nutmeg.com/nutmegonomics/increasing-your-chances-of-positive-portfolio-returns-the-facts-about-long-term-investing/" target="_blank">
      See how your risk of losses decreases the longer you hold your investments <i class="fa fa-external-link"></i>
    </a>
  </p>
</div>

<div class="modal-footer">
  <button ng-click="ctrl.closeModal()" class="btn btn-default btn-block">
    OK
  </button>
</div>

</script>
<script type="text/ng-template" id="lisa_timeframe_help_modal.html">
  <div class="modal-header">
  <h1>When are you likely to use this money?</h1>
</div>
<div class="modal-body">
  <p>
    <strong>Why set a timeframe?</strong>
  </p>
  <p>
    We use your timeframe – the length of time you can leave your money invested and untouched – and attitude to risk to suggest a portfolio that we think is right for you.
  </p>
  <p>
    Generally, the sooner you need the money, the less risk you should take as, should the market fall, your investments will have less time to recover. Conversely, if you have a
    longer timeframe, you may be able to take more risk, as your investments will have more time to recover.
  </p>
  <p>
    We also use your timeframe to project how much money you might have in the future to help you plan any contributions and increase the chance of reaching a goal.
  </p>
  <br>
  <p>
    <strong>Choosing a timeframe for a goal</strong>
  </p>
  <p>
    The length of time you invest for should relate to your investment goal. As you are investing in a Lifetime ISA, you are planning to either use the money to help buy a house,
    or to spend after age 60.
  </p>
  <p>
    Buying a house tends to be a shorter-term plan. Think about when you are likely to need this money to help pay the deposit on your first home.
  </p>
  <p>
    If you are planning to use the Lifetime ISA after age 60, work out how many years it will be until you are sixty, as you cannot access the money without penalty before then.
    You may be thinking even longer term, for example when you retire, or when you qualify for the state pension.
  </p>
  </p>
</div>

<div class="modal-footer">
  <button ng-click="ctrl.closeModal()" class="btn btn-default btn-block">
    OK
  </button>
</div>

</script>

      </div>

      <div ng-if="ctrl.isCurrentStep('contributions')">
        <div class="container contributions">

  <br>
  <br class="hidden-xs">
  <h1 id="contributions-title" class="text-center max-270">How much can you invest?</h1>
  <br>
  <br>

  <div class="row">
    <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 col-lg-6 col-lg-offset-3">

      <div class="hidden-xs">

        <div class="max-460-container">

          <div ng-if="ctrl.shouldDisplayStartingAmount()">
            <h3 class="caps">{{ ctrl.isLisaAccount() ? '' : 'Starting' }} amount</h3>

            <div class="row">
              <div class="col-sm-8">
                <rzslider rz-slider-model="ctrl.pot.contributions.starting"
                          rz-slider-options="ctrl.sliders.starting"></rzslider>
              </div>
              <div class="col-sm-4">
                <div class="form-group">
                  <input type="text" class="form-control standalone" id="starting"
                         name="starting" ui-money-mask="0"
                         ng-model="ctrl.pot.contributions.starting" positive required />
                </div>
              </div>
            </div>

            <div class="clearfix"></div>
          </div>

          <div id="min-start-amount" ng-if="!ctrl.minValidStartingAmt()" style="text-align: center; margin: 15px 0;">
            Minimum starting amount is
            <strong>{{ ctrl.validations.starting.min | poundCurrency }}</strong>
          </div>

          <div id="max-start-amount" ng-if="!ctrl.maxValidStartingAmt()" style="text-align: center; margin: 15px 0;">
            Maximum starting amount is
            <strong>{{ ctrl.validations.starting.max | poundCurrency }}</strong>
          </div>
          
          <div ng-if="ctrl.displayUnallocatedMessage()" class="well" style="margin: 20px 0 0;">
            {{ ctrl.unallocatedMessage() }}
          </div>

          <br>

          <div ng-if="!ctrl.isLisaAccount()">
            <h3 class="caps">Monthly</h3>

            <div class="row">
              <div class="col-sm-8">
                <rzslider rz-slider-model="ctrl.pot.contributions.monthly"
                          rz-slider-options="ctrl.sliders.monthly"></rzslider>
              </div>
              <div class="col-sm-4">
                <div class="form-group">
                  <input type="text" class="form-control standalone" id="monthly"
                         name="monthly" ui-money-mask="0"
                         ng-change="ctrl.watchMonthlyDefaults()"
                         ng-model="ctrl.pot.contributions.monthly" required />
                </div>
              </div>
            </div>

            <div id="min-amount-below" ng-if="!ctrl.validMonthlyAmt()" style="text-align: center; margin: 15px 0;">
              {{ ctrl.validations.monthly.min | poundCurrency }}/mo
              required for amounts below
              {{ ctrl.validations.starting.requireMonthlyBelow | poundCurrency }}
            </div>
          </div>

        </div>
      </div>

      <div class="visible-xs">
        <div ng-if="ctrl.shouldDisplayStartingAmount()">
          <div class="form-group label-inside">
            <label for="starting">{{ ctrl.isLisaAccount() ? '' : 'Starting' }} amount</label>
            <input class="form-control" id="starting" ui-money-mask="0"
                   ng-model="ctrl.pot.contributions.starting" required />
          </div>

          <div id="min-start-amount" ng-if="!ctrl.minValidStartingAmt()" style="text-align: center; margin: 15px 0;">
            Minimum starting amount is
            <strong>{{ ctrl.validations.starting.min | poundCurrency }}</strong>
          </div>

          <div id="max-start-amount" ng-if="!ctrl.maxValidStartingAmt()" style="text-align: center; margin: 15px 0;">
            Maximum starting amount is
            <strong>{{ ctrl.validations.starting.max | poundCurrency }}</strong>
          </div>
        </div>

        <div ng-if="!ctrl.isLisaAccount()">
          <div class="form-group label-inside">
            <label for="monthly">Monthly</label>
            <input class="form-control" id="monthly" ui-money-mask="0"
                   ng-change="ctrl.watchMonthlyDefaults()"
                   ng-model="ctrl.pot.contributions.monthly" required />
          </div>

          <div id="min-amount-below" ng-if="!ctrl.validMonthlyAmt()" style="text-align: center; margin: 15px 0;">
            {{ ctrl.validations.monthly.min | poundCurrency }}/mo
            required for amounts below
            {{ ctrl.validations.starting.requireMonthlyBelow | poundCurrency }}
          </div>
        </div>
      </div>

      <br><br>

      <p id="contributions-footer" class="text-center" ng-if="!ctrl.isLisaAccount()">
        Monthly contributions can be changed at any time.
      </p>

      <div ng-if="ctrl.isLisaAccount()">
        <p class="text-center">You can always contribute more by opening an additional ISA, pension, or general investment account at any time.</p>
      </div>

      <br>

      <button class="btn btn-primary btn-block pinned-bottom max-300"
              ng-click="ctrl.submitContributions('investment_style')"
              ng-disabled="!ctrl.validContributions()"
              ng-if="!ctrl.isEditingOption()"
              id="submit_contributions">
        Continue
      </button>

      <button class="btn btn-primary btn-block pinned-bottom max-300"
              ng-click="ctrl.goToStep('risk')"
              ng-disabled="!ctrl.validContributions()"
              ng-if="ctrl.isEditingOption()"
              id="refresh_charts_contributions">
        Review changes
      </button>

      <div class="text-center">
        <a class="" ng-click="ctrl.openContributionsHelpModal()">Need help deciding?</a>
      </div>

      <br><br><br>

    </div>
  </div>

</div>

<script type="text/ng-template" id="contributions_help_modal.html">
  <div class="modal-header">
  <h1>Good rules of thumb</h1>
</div>
<div class="modal-body">
  <p>
    <strong>Let compounding do its work</strong>
  </p>
  <p>
    Investing more, earlier, gives your investments more time to benefit from compounding. Plus, investing monthly automates your saving and helps smooth out the inevitable ups and downs along the way. Remember that when investing your capital is at risk.
  </p>
  <br>
  <p>
    <strong>Just make sure you have enough cash for emergencies</strong>
  </p>
  <p>
    We believe that it’s smart to have enough cash on hand &mdash; not in investments
    &mdash; to cover 3 months of expenses in case things go awry.
  </p>
  <br>
  <p>
    <strong>Don't worry</strong>
  </p>
  <p>
    You can change your monthly amount anytime.
  </p>

</div>

<div class="modal-footer">
  <a href="javascript:void(0)" ng-click="ctrl.closeModal()" class="btn btn-default btn-block">
    OK
  </a>
</div>

</script>

      </div>

      <div ng-if="ctrl.isCurrentStep('investment_style')">
        <div class="container investment-style">

  <br>
  <br class="hidden-xs">
  <h1 class="text-center max-270">Choose an investment style for this pot</h1>
  <br>

  <div class="row">
    <div class="col-xs-12 col-lg-10 col-lg-offset-1">

      <div class="row">

        <div id="investment-style-choice" class="col-sm-6 radio-group">

          <label id="opt_managed" ng-click="ctrl.selectInvestmentStyle('managed')">
            <div class="radio-circle" ng-class="{ 'selected': ctrl.shouldShowInvestmentStyleSelection() && ctrl.pot.investmentStyle == 'managed' }"></div>
            <div class="radio-desc">
              <div class="radio-title">Fully managed</div>
              <p>
                Our experienced team will design and
                watch over your investments, making
                strategic adjustments to try and protect
                against losses and boost returns.
              </p>
              <strong>Fee: 0.75% up to £100k, 0.35% after that</strong>
            </div>
          </label>

          <div class="clearfix"></div>
          <br>

          <label id="opt_fixed" ng-click="ctrl.selectInvestmentStyle('fixed')">
            <div class="radio-circle" ng-class="{ 'selected': ctrl.shouldShowInvestmentStyleSelection() && ctrl.pot.investmentStyle == 'fixed' }"></div>
            <div class="radio-desc">
              <div class="radio-title">Fixed allocation</div>
              <p>
                A robust portfolio designed by our team
                and automatically rebalanced to stay in
                line with your chosen risk level. Beyond
                that we keep our hands off.
              </p>
              <strong>Fee: 0.45% up to £100k, 0.25% after that</strong>
            </div>
          </label>

        </div>

        <br class="visible-xs" />
        <br class="visible-xs" />

        <div class="col-sm-6" id="with-both-options">
          <p>With both options:</p>

          <ul class="fa-ul">
            <li>
              <i class="fa fa-li fa-check"></i>
              You&#8217;ll have a wide range of risk levels available,
              from very conservative to adventurous
            </li>
            <li>
              <i class="fa fa-li fa-check"></i>
              You stay in control of your risk and contributions
            </li>
            <li>
              <i class="fa fa-li fa-check"></i>
              You get a smart, globally-diversified portfolio with investment fund costs averaging 0.19%
            </li>
            <li>
              <i class="fa fa-li fa-check"></i>
              Your investments are automatically kept in line
              with your preferred risk level
            </li>
            <li>
              <i class="fa fa-li fa-check"></i>
              We cover all basics, like trading and dividend
              reinvestment, so you don&#8217;t have to
            </li>
          </ul>

        </div>

      </div>

      <br>

      <p class="text-center" style="margin: 5px 0 20px 0;">
        <a ng-click="ctrl.openInvestmentStyleHelpModal()"
           style="margin:0">Need help deciding?</a>
      </p>

      <button class="btn btn-primary btn-block pinned-bottom max-300"
              ng-click="ctrl.submitInvestmentStyle()"
              ng-disabled="ctrl.disableInvestmentStyleSubmit()"
              ng-if="!ctrl.isEditingOption()"
              id="submit_investment_style">
        Continue
      </button>

      <button class="btn btn-primary btn-block pinned-bottom max-300"
              ng-click="ctrl.submitInvestmentStyle()"
              ng-disabled="ctrl.disableInvestmentStyleSubmit()"
              ng-if="ctrl.isEditingOption()"
              id="refresh_charts_investment_style">
        Review changes
      </button>

      <p class="text-center">
        Change your mind anytime.
      </p>

      <br><br>

    </div>
  </div>

</div>

<script type="text/ng-template" id="investment_style_help_modal.html">
  <div class="modal-header">
  <h1>Here&#8217;s how others have made this decision</h1>
</div>
<div class="modal-body">
  <p><strong>People who prefer fully managed...</strong></p>
  <p>
    Tend to be reassured by having an
    experienced team monitor the
    markets for them, seeking to protect
    from falls and take advantage of
    market events and cycles. They&#8217;re
    also willing to pay a bit extra for this
    peace of mind.
  </p>

  <br>

  <p><strong>People who prefer fixed allocation...</strong></p>
  <p>
    Tend to believe in the long-term
    performance of the markets, and
    consequently are committed to riding
    out the inevitable ups and downs
    without human intervention.
  </p>

  <br>

  <p><strong>Don't worry</strong></p>
  <p>You can change between fixed allocation or fully managed at any time.</p>
</div>

<div class="modal-footer">
  <a href="javascript:void(0)" ng-click="ctrl.closeModal()" class="btn btn-default btn-block">
    OK
  </a>
</div>

</script>

      </div>

      <div ng-if="ctrl.isCurrentStep('risk')">
        <div class="container risk">

  <br>
  <br class="hidden-xs">
  <h1 id="risk-level-title" class="text-center max-270">Set a risk/reward balance</h1>
  <br>
  <br>

  <div class="row">
    <div class="col-xs-12 col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2">

      <div class="max-460-container">

        <div class="risk-level-label {{ctrl.pot.investmentStyle}}-band {{ctrl.pot.investmentStyle}}-band-{{ ctrl.pot.riskLevel }}">
          <div class="risk-level-number" ng-if="ctrl.pot.investmentStyle == 'managed'">
            {{ ctrl.pot.riskLevel }}
          </div>
          <div class="risk-level-text">
            {{ ctrl.riskDescription() }}
          </div>
        </div>

        <div class="clearfix"></div>
        <br>

        <rzslider id="risk_level_slider"
                  rz-slider-model="ctrl.pot.riskLevel"
                  rz-slider-options="ctrl.sliders.risk"
                  style="margin-top: 10px; margin-bottom: 5px;"
                  class="{{ctrl.pot.investmentStyle}}-band {{ctrl.pot.investmentStyle}}-band-{{ ctrl.pot.riskLevel }}"></rzslider>

        <input type="text" ng-model="ctrl.pot.riskLevel"
               ng-change="ctrl.resetRiskAcceptance()"
               id="risk_level" class="input-helper" />

        <div class="clearfix"></div>

        <div class="row">
          <div class="col-xs-6">
            <span class="diminished text-left">
              Low risk/reward
            </span>
          </div>
          <div class="col-xs-6">
            <span class="diminished text-right pull-right">
              High risk/reward
            </span>
          </div>
        </div>

        <div id="risk_level_suggestion" ng-if="ctrl.startingNewFund || ctrl.editingExistingPot">
          <div class="highlight_preferred_risk_level" ng-style="ctrl.preferredRiskLevelStyle"></div>
          <div class="suggested_risk_level" ng-style="{ 'left': ctrl.calculateSuggestedRiskLevelCSSPosition(ctrl.riskPreference.suggestedRiskLevel) }"></div>

          <div class="suggestion-callout">
            <div class="suggested-number {{ctrl.pot.investmentStyle}}-band">
              {{ ctrl.riskPreference.suggestedRiskLevel }}
            </div>
            <div class="suggested-text">
              The preferred risk level for people with your timeframe and risk
              tolerance.
            </div>
          </div>
        </div>

      </div>

      <br><br>
      <p ng-if="ctrl.pot.accountType == 'lisa'" id="warn-for-short-time-investors" class="text-center">
        If you’re saving for a home on a short timeframe (3-5 years), you may want to think about using a lower risk level to reduce your chances of ending up with substantially less than you planned.
      </p>
      <p class="text-center">
        You can change your risk level anytime.
      </p>
      <br>

      <button class="btn btn-primary btn-block pinned-bottom max-300"
              ng-click="ctrl.checkRiskBoundaries()"
              ng-disabled="ctrl.isEditingOption() || !ctrl.canSubmitRiskLevel()"
              ng-if="!ctrl.isEditingOption()"
              id="submit_risk_level">
        Continue
      </button>

      <button class="btn btn-primary btn-block pinned-bottom max-300"
              ng-click="ctrl.checkRiskBoundaries()"
              ng-if="ctrl.isEditingOption()"
              ng-disabled="!ctrl.canSubmitRiskLevel()"
              id="refresh_charts_risk_level">
        Review changes
      </button>

      <div class="text-center">
        <a class="" ng-click="ctrl.openRiskHelpModal()">Need help deciding?</a>
      </div>

      <br><br><br>

    </div>
  </div>

</div>

<script type="text/ng-template" id="risk_help_modal.html">
  <div class="modal-header">
  <h1>What's the right risk level for you?</h1>
</div>
<div class="modal-body">
  <p>
    <strong>Risk is an important part of investing</strong>
  </p>
  <p>
    Over the long term, high-risk investments tend to outperform low-risk investments.
    However, they see larger rises and falls along the way.
  </p>
  <br>
  <p>
    <strong>Take less risk if...</strong>
  </p>
  <p>
    Your goal is short-term (3-5 years) and important, or if you’re worried about
    investing in the first place.
  </p>
  <br>
  <p>
    <strong>Take more risk if...</strong>
  </p>
  <p>
    Your goal is long-term, and you’re committed to riding out the ups and downs along the way.
  </p>
  <br>
  <p>
    <strong>Don't worry</strong>
  </p>
  <p>
    You can change risk anytime. Plus, before you invest, we’ll ask you a few questions
    to ensure that your chosen risk level is suitable for you.
  </p>

</div>

<div class="modal-footer">
  <a href="javascript:void(0)" ng-click="ctrl.closeModal()" class="btn btn-default btn-block">
    OK
  </a>
</div>

</script>

      </div>
    </form>

    <div ng-if="ctrl.isCurrentStep('portfolio')">
      <div class="show-portfolio" ng-class="ctrl.isPastStep('pot_details') ? 'two-row' : ''">

  <ul class="nav nav-tabs pot-nav-tabs hidden-xs" role="tablist">
    <div class="container-fluid">
      <li ng-hide="ctrl.isLisaAccount()" ng-class="ctrl.isCurrentTab('projection') ? 'active' : ''">
        <a ng-click="ctrl.setCurrentTab('projection')" id="projection_tab">Projection</a>
      </li>
      <li ng-show="ctrl.isLisaAccount()" ng-class="ctrl.isCurrentTab('lisa_projection') ? 'active' : ''">
        <a ng-click="ctrl.setCurrentTab('lisa_projection')" id="lisa_projection_tab">Projection</a>
      </li>
      <li ng-class="ctrl.isCurrentTab('portfolio') ? 'active' : ''">
        <a ng-click="ctrl.setCurrentTab('portfolio')" id="portfolio_tab">Portfolio</a>
      </li>
      <li ng-class="ctrl.isCurrentTab('historical') ? 'active' : ''">
        <a ng-click="ctrl.setCurrentTab('historical')" id="historical_tab">Historical</a>
      </li>
    </div>
  </ul>

  <div class="container-fluid">

    <p class="text-center diminished visible-xs" style="margin-top: 5px;">Tap any setting to edit</p>

    <br>

    <div class="row">

      <div class="col-sm-7">

        <div ng-show="ctrl.isCurrentTab('projection') && !ctrl.isLisaAccount()" class="summary-tab" id="projection-tab">
          <h2>
            Projection
            <p>How we project this portfolio to perform &mdash; hover or tap on chart for details</p>
          </h2>

          <!-- Charts and content goes here -->
          <div class="projection-chart-container">
            <div id="projectionsChart"></div>
            <div class="simple-chart-key">
              <div class="blue-circle"></div> More likely
              <div class="clearfix"></div>
              <div class="light-blue-circle"></div> Less likely
              <div class="clearfix" style="margin-top: 2px;"></div>
              <div class="contributions-line"></div> Contributed
            </div>
          </div>

          <br>
          <div ng-if="ctrl.potOffTrack()">

  <div class="well">
    <p>
      <strong>
        <i class="fa fa-warning"></i>
        Off track from {{ ctrl.pot.target | poundCurrency }} &mdash; How to get back on track:
      </strong>
    </p>
    <div class="row tight-gutter-10 lg-only">
      <div class="col-lg-6">
        <a href="javascript:void(0)"
           ng-click="ctrl.increaseContributions()"
           class="btn btn-default btn-block">
          Pay in {{ ctrl.trackSuggestions.monthly_contribution | poundCurrency }}/month
        </a>
      </div>
      <div class="col-lg-6">
        <a href="javascript:void(0)"
           ng-click="ctrl.extendTimeframe()"
           class="btn btn-default btn-block">
          Extend timeframe to {{ ctrl.trackSuggestions.timeframe }} years
        </a>
      </div>
    </div>
  </div>
  <br>
</div>

<div ng-if="ctrl.potOnTrack()">

  <div class="well pot-on-track">
    <strong>
      <i class="fa fa-check"></i>
      On track for {{ ctrl.pot.target | poundCurrency }} target
    </strong>
  </div>
  <br>
</div>


        </div>

        <div id="lisa_projection-tab" class="summary-tab">
          <div ng-show="ctrl.isCurrentTab('lisa_projection') && !ctrl.isAccountAgeValidForLisa()">
            <div class="panel panel-default text-center">
              <div class="panel-body">
                <div class="row">
                  <div class="col-md-12">
                    <h2>We need to know your age before<br/>we can show you a projection</h2>
                  </div>
                </div>
                <div class="row" ng-show="ctrl.showAlertInvalidAgeForLisa">
                  <div class="col-md-12 input-group-btn">
                    <div class="alert alert-danger">
                      You must be aged 18-39 to open a Lifetime ISA. <a class="other-account-types-link" href="javascript:void(0)" ng-click="ctrl.closeModal();">One of our other account types</a> might be more appropriate for you
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12 input-group-btn">
                    <input placeholder="Age (years)" class="form-control form-control-age" id="lisa-review-age" ng-model="ctrl.inputAge" />
                    <button class="btn btn-primary btn-padding" ng-click="ctrl.validateAge()" id="lisa-review-age-submit-button">Continue</button>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div ng-show="ctrl.isCurrentTab('lisa_projection') && ctrl.isAccountAgeValidForLisa() && !ctrl.lisaProjectionDataLoaded" class="lisa-projection-spinner">
            <i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
          </div>

          <div ng-show="ctrl.isCurrentTab('lisa_projection') && ctrl.isAccountAgeValidForLisa() && ctrl.lisaProjectionDataLoaded">
            <div class="panel panel-default lisa-projection">
              <div class="panel-heading">
                <span class="label-title">After 
                  <span ng-if="ctrl.pot.timeframe > 0">{{ ctrl.pot.timeframe }}</span>
                  <span ng-if="ctrl.pot.timeframe == 0">10+</span> 
                years, assuming {{ ctrl.pot.contributions.starting | poundCurrency }} contributed at start of each tax year</span>
              </div>
              <div class="panel-body">
                <div class="row">
                  <div class="col-md-3">
                    <div class="contributions">
                      <div class="your-contributions-text">Your contributions</div>
                      <div class="your-contributions-amount"><h2>{{ ctrl.lisaProjection.contributions | poundCurrency }}</h2></div>
                      <div class="government-bonuses-text">Government bonuses</div>
                      <div class="government-bonuses-amount"><h2>{{ ctrl.lisaProjection.bonus | poundCurrency }}</h2></div>
                    </div>
                  </div>
                  <div class="col-md-9">
                    <div class="projection-figures">
                      <div class="row">
                        <div class="col-md-6">
                          <div>50% chance of having at least</div>
                          <div class="fifty-chance-amount">{{ ctrl.lisaProjection.average | poundCurrency }}</div>
                        </div>
                        <div class="col-md-6">
                          <br class="visible-xs visible-sm" />
                          <div>5% chance of having less than</div>
                          <div class="five-chance-amount">{{ ctrl.lisaProjection.leftTail | poundCurrency }}</div>
                        </div>
                      </div>
                      <br>
                      <a href="javascript:void(0)" ng-click="ctrl.openLisaProjectionModal()">How we calculated these figures <i class="fa fa-angle-right"></i></a>
                    </div>
                  </div>
                </div>
              </div>
              <hr style="margin: 0;" />
              <div class="projection-footer">
                <div ng-if='!ctrl.account.lisaOverSixty'>
                  <p>It looks like you plan to use the money before age 60. Here's what you need to know:</p>
                  <ul>
                    <li>You can use it to purchase your first home, costing less than £450,000</li>
                    <li>You can also use it for terminal illness</li>
                    <li>However, for any other reason before age 60, <a href="https://www.nutmeg.com/lifetime-isa/lifetime-isa-faq#cost-of-early-withdrawal" target="_blank">you’ll pay a 25% government penalty</a></li>
                  </ul>
                  <p><b>Remember that forecasts are not a reliable indicator of future performance.</b></p>
                </div>
                <div ng-if='ctrl.account.lisaOverSixty == true'>
                  <p>It looks like you plan to use the money after age 60, at which point you can withdraw it freely. Withdrawing before age 60, and not for a first home, usually comes with a <a href="https://www.nutmeg.com/lifetime-isa/lifetime-isa-faq#can-i-access-savings" target="_blank">penalty</a></p>
                  <p><b>Remember that forecasts are not a reliable indicator of future performance.</b></p>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div ng-show="ctrl.isCurrentTab('portfolio')" class="summary-tab" id="portfolio-tab">

          <!-- Charts and content goes here -->
          <div class="row">
            <div class="col-lg-6">
              <h2>
                Portfolio
                <p>What you'll own in this portfolio</p>
              </h2>
              <div id="pieChart"></div>
            </div>
            <br class="visible-xs visible-sm" />
            <div class="col-lg-6">
              <h2>List of investments</h2>

              <div id="overflow-box" ng-class="{ 'max-height-300': ctrl.restrictDivHeight() }">
                <table class="table" id="investments-table">
                  <thead>
                    <tr>
                      <th>Ticker</th>
                      <th>Name</th>
                      <th class="text-right">Percentage</th>
                    </tr>
                  </thead>

                  <tbody>
                    <tr ng-repeat="investment in ctrl.investmentsTable track by $index">
                      <td>{{ investment.code }}</td>
                      <td>
                        <span tooltip="{{ ctrl.tooltips[investment.code] }}">
                          {{ investment.description }}
                        </span>
                      </td>
                      <td class="text-right">{{ investment.allocation }}</td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <a ng-show="ctrl.tooTall('investments-table')" ng-click="ctrl.toggleExpand()" class="scroll-cover">
                See {{ctrl.restrictDivHeight() ? 'all' : 'less'}}
              </a>
              <br>
            </div>
          </div>

        </div>

        <div ng-show="ctrl.isCurrentTab('historical')" class="summary-tab" id="historical-tab">
          <h2>
            Historical
            <p>Returns of a comparable portfolio over the past 20 years</p>
          </h2>

          <!-- Charts and content goes here -->
          <div class="row tight-gutter-10 historical-figures">
            <div class="col-xs-3 best">
              <h1 class="annual-return-{{ ctrl.managedRiskLevel }}"></h1>
              <p>Avg. annual return</p>
            </div>
            <div class="col-xs-3 best">
              <h2 class="best-year-{{ ctrl.managedRiskLevel }}"></h2>
              <p>Best year, <span class="best-cal-year-{{ ctrl.managedRiskLevel }}"></span></p>
            </div>
            <div class="col-xs-3 worst">
              <h2 class="worst-year-{{ ctrl.managedRiskLevel }}"></h2>
              <p>Worst year, <span class="worst-cal-year-{{ ctrl.managedRiskLevel }}"></span></p>
            </div>
            <div class="col-xs-3 worst">
              <h2 class="worst-12mo-{{ ctrl.managedRiskLevel }}"></h2>
              <p>Worst 12 mo. period</p>
            </div>
          </div>
          <div class="historical-chart-img risk-level-{{ ctrl.managedRiskLevel }}"></div>
          <p>Remember, past performance is no guarantee of future returns and losses over any 12-month period may be greater than losses during any discrete calendar year.</p>
          <br>

        </div>

      </div>

      <div class="col-sm-5">

        <div ng-if="ctrl.isCreatingAnAccount()" id="extra-new-pot-info">
          <div class="why-nutmeg-info">
  <h2>Why Nutmeg</h2>

  <p ng-if="ctrl.isLisaAccount()">
    <a id="lisa-key-feats-link" target="_blank" href="http://resources.nutmeg.com/Nutmeg-Lifetime-ISA-Information-Pack.pdf"><i class="fa fa fa-file-pdf-o" aria-hidden="true"></i>
      Read the Lifetime ISA Information Pack
    </a>
  </p>

  <ul ng-if="!ctrl.isLisaAccount()" class="fa-ul">

    <li ng-if="ctrl.pot.investmentStyle == 'managed'"><i class="fa-li fa fa-check"></i> Intelligent, diversified portfolio</li>
    <li ng-if="ctrl.pot.investmentStyle == 'managed'"><i class="fa-li fa fa-check"></i> Fully managed by our experienced team for extra peace of mind</li>
    <li ng-if="ctrl.pot.investmentStyle == 'managed'"><i class="fa-li fa fa-check"></i> A fee of 0.75% up to £100k, 0.35% after that</li>

    <li ng-if="ctrl.pot.investmentStyle == 'fixed'"><i class="fa-li fa fa-check"></i> Global, multi-asset portfolio crafted by our experienced team</li>
    <li ng-if="ctrl.pot.investmentStyle == 'fixed'"><i class="fa-li fa fa-check"></i> Fully-automated rebalancing and dividend reinvestment</li>
    <li ng-if="ctrl.pot.investmentStyle == 'fixed'"><i class="fa-li fa fa-check"></i> A fee of 0.45% up to £100k, 0.25% after that</li>

    <li><i class="fa-li fa fa-check"></i> No setup, exit, nor trading fees</li>
    <li><i class="fa-li fa fa-check"></i> Brilliant customer support</li>
    <li><i class="fa-li fa fa-check"></i> An award-winning, easy-to-use platform</li>

  </ul>

  <ul ng-if="ctrl.isLisaAccount()" class="fa-ul">

    <li ng-if="ctrl.pot.investmentStyle == 'managed'"><i class="fa-li fa fa-check"></i> Fees of 0.75% on up to £100k, 0.35% beyond</li>

    <li ng-if="ctrl.pot.investmentStyle == 'fixed'"><i class="fa-li fa fa-check"></i> Fees of 0.45% on up to £100k, 0.25% beyond</li>

    <li><i class="fa-li fa fa-check"></i> No exit fees. No trading fees.</li>
    <li><i class="fa-li fa fa-check"></i> Change risk and other settings anytime</li>
    <li><i class="fa-li fa fa-check"></i> Get a 25% government bonus on up to £4,000</li>
    <li><i class="fa-li fa fa-check"></i> Tax-free returns when used for your first home or retirement (<a href="https://www.nutmeg.com/lifetime-isa/lifetime-isa-faq" target="_blank">see restrictions</a>)</li>
    <li><i class="fa-li fa fa-check"></i> Award-winning web and mobile apps</li>
    <li><i class="fa-li fa fa-check"></i> Brilliant customer support</li>

  </ul>

  <br>

</div>


          <button class="btn btn-primary btn-padding pinned-bottom"
             ng-click="ctrl.goToStep('security');" ng-disabled="!ctrl.isProjectionLoaded()"
             id="create_an_account">
            Create a Nutmeg account
          </button>
        </div>

        <div ng-if="ctrl.startingNewFund || ctrl.editingExistingPot" id="extra-new-pot-info">
          <h2 class="hidden-xs">All set?</h2>

          <button class="btn btn-primary btn-padding pinned-bottom"
             ng-click="ctrl.submitPot();"
             id="create_new_pot"
             ng-disabled="!ctrl.pot.uuid || !ctrl.isAccountAgeValidForLisa() || !ctrl.isProjectionLoaded()">
            Confirm
          </button>
        </div>

      </div>

    </div>

    <div class="clearfix"></div>

    <div ng-show="ctrl.isCurrentTab('projection')" class="well traditional">
  <h3>Your investments may lose value</h3>
  <p style="margin-bottom: 0;">
    Projections are never a perfect predictor of future performance, and are
    intended as an aid to decision-making, not as a guarantee. The projection
    includes the effect of fees, assumes income is reinvested and does not take
    into account the effects of inflation or tax.
    <a href="javascript:void(0)" ng-click="ctrl.openProjectionModal()">More <i class="fa fa-angle-right"></i></a>
  </p>
</div>

<div ng-show="ctrl.isCurrentTab('lisa_projection')" class="well traditional">
  <h3>Your investments may lose value</h3>
  Figures include the effect of 0.75% Nutmeg fee and 0.19% avg. investment fund cost. Before age 60, LISAs can only be used to purchase your first home, and it must be under £450,000. Otherwise, you may incur a 25% government penalty. <a href="https://www.nutmeg.com/lifetime-isa/lifetime-isa-faq#can-i-access-savings" target="_blank">Learn more</a>
</div>

<div ng-show="ctrl.isCurrentTab('portfolio')" class="well traditional hidden-xs">
  <h3 style="margin-bottom: 0;">Your investments may lose value</h3>
</div>

<div ng-show="ctrl.isCurrentTab('historical')" class="well traditional">
  Historical figures are based on the performance of a portfolio consisting of <span class="portfolio-mix-{{ ctrl.pot.riskLevel }}"></span>, which is comparable to the long-term average asset mix for this portfolio. Divergence from this allocation could lead to significantly different returns from those shown here. The returns are intended as an example of the ups and downs of markets, rather than any guarantee of performance. Source data: Macrobond.
</div>

<hr>

<ul class="fa-ul">
  <li>
    <i class="fa fa-li fa-lock"></i> Authorised and regulated by the Financial Conduct Authority (FCA). Your assets are held with one of the world's largest custodians. Protected by 128-bit TLS security.
  </li>
</ul>

<hr>

<div class="row">
  <div class="col-sm-8">
    <p class="diminished">
       We offer restricted advice, which is limited to recommending a suitable model portfolio from our range. We will not assess your whole financial circumstances or consider all financial products and services that could be suitable.
    </p>
    <p class="diminished pull-left">&copy; 2017 Nutmeg Saving and Investment Limited</p>
  </div>
  <div class="col-sm-4">
    <ul class="pull-right list-style-none list-inline" style="margin-top: 0px;">
      <li>
        <a target="_blank" href="https://www.nutmeg.com">About</a>
      </li>
      <li>
        <a target="_blank" href="https://www.nutmeg.com/legal/privacy-policy">Legal</a>
      </li>
      <li>
        <a target="_blank" href="//support.nutmeg.com/hc/en-us/">Help</a>
      </li>
    </ul>
  </div>
</div>

<div class="clearfix"></div>
<br>
<br>
<br>

<script type="text/ng-template" id="projection_modal.html">
  <div class="modal-header">
  <h1>How is the projection calculated?</h1>
</div>
<div class="modal-body">
  We calculate the expected long-term average returns for each portfolio as
  well as the spread of likely outcomes that you see shown in the chart using
  long-term historical data. These projected returns are based on the
  estimated returns for a portfolio of equities and government bonds, in
  different percentages depending on the portfolio risk level. In general,
  the higher the risk of a portfolio the greater the proportion of
  equities - both in the UK and overseas - and so a higher level of expected
  return.
  
  <br><br>
  
  The fan charts identify the probabilities of achieving various possible
  outcomes at different time horizons, based on the historic volatility of
  each asset class since 1986. The range of theoretical return projections
  are calculated using expected returns and volatility.
  
  <br><br>
  
  The projections include the effect of an annual fee of 1.0% (including VAT).
  We also assume both that income is reinvested and that any monthly
  contributions you select are maintained.
  
  <br><br>
  
  The projections do not include the effects of tax on investment income, tax
  on capital gains, of changing your risk profile, or of future changes to
  our investment strategy.
</div>

<div class="modal-footer">
  <a href="javascript:void(0)" ng-click="ctrl.closeModal()" class="btn btn-success btn-block">
    Close
  </a>
</div>
</script>

<script type="text/ng-template" id="lisa_projection_modal.html">
  <div class="modal-header">
  <h1>How we calculated these figures</h1>
</div>
<div class="modal-body">
  <p>
    We calculate the expected long-term average returns for each portfolio as well as the likely outcomes using
    long-term historical data<sup>[1]</sup>. These projected returns are based on the estimated returns for a portfolio of
    equities and government bonds, in different percentages depending on the portfolio risk level. In general,
    the higher the risk of a portfolio the greater the proportion of equities - both in the UK and overseas - and
    so a higher level of expected return.
  </p>
  <p>
    The calculations identify the probabilities of achieving various possible outcomes at different time horizons,
    based on the historic volatility of each asset class since 1990. The range of theoretical return projections
    are calculated using expected returns and volatility.
  </p>
  <p>
    The projections include the effect of 0.75% Nutmeg fee and 0.2% average investment fund cost. We also
    assume both that income is reinvested and that the starting contribution you select is made at the start of
    each tax year.
  </p>
  <p>
    The projections do not include the effects of inflation, of tax on investment income or on capital gains,
    of changing your risk profile, or of future changes to our investment strategy.
  </p>
  <p>
    1. Sources: Macrobond and Bloomberg – 1990 - 2015
  </p>
</div>

<div class="modal-footer">
  <a href="javascript:void(0)" ng-click="ctrl.closeModal()" class="btn btn-default btn-block">
    Close
  </a>
</div>

</script>

<script type="text/ng-template" id="lisa_unavailable_tax_year_modal.html">
  <div class="modal-header">
  <h1>You already paid into a Lifetime ISA this tax year</h1>
</div>
<div class="modal-body">
  You can only pay into one Lifetime ISA in each tax year. Since you’ve already done that in the current tax year (even 
  if you’ve since closed the pot), you’ll have to wait until the new tax year on 6th April to set up another Lifetime 
  ISA.
</div>

<div class="modal-footer">
  <a class="btn btn-success btn-block" data-ignore="push" href="/client/portfolio">Back to home</a>
</div>
</script>


  </div>

</div>

    </div>

    <div ng-show="ctrl.isCurrentStep('security')">
      <div class="container">

  <br>
  <br class="hidden-xs">
  <h1 class="text-center">Set a password</h1>
  <br>
  <br>

  <div class="row">
    <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4">

      <div style="width: 300px; margin: 0 auto;">
        <form name="newAccountForm" novalidate>
          <div class="text-center" ng-if="ctrl.displayEmail()" id="prospect_email">
            {{ ctrl.account.email }}
            <i class="fa fa-pencil" ng-click="ctrl.editAccountEmail()"></i>
          </div>

          <br>

          <div class="form-group no-mobile-stretch single-line-mobile">
            <input type="email" ng-model="ctrl.account.email" ng-show="!ctrl.displayEmail()" autocomplete="off"
                   ng-change="ctrl.resetExistingUserFlag()"
                   ng-model-options="{ updateOn: 'blur' }"
                   ng-pattern="ctrl.validEmailPattern"
                   required id="account_email" name="account_email" class="form-control standalone"
                   placeholder="Email" />

            <input id="password" class="form-control standalone"
                   required name="password"
                   ng-model="ctrl.account.password"
                   ng-change="newAccountForm.$setPristine()"
                   type="password" placeholder="Password" />

            <br>
            Password strength: {{ctrl.passwordScore}}%
            <div class="progress thin password-strength">
              <div class="progress-bar" ng-class="'strength-'+ctrl.passwordScore"></div>
            </div>

            <div class="password-requirements" ng-repeat="requirement in ctrl.passwordRequirements">
              <i class="fa fa-check" ng-class="requirement.fulfilled ? 'fulfilled' : 'needed'"></i>
              <strong>{{requirement.text}}</strong>
            </div>
            <div ng-repeat="suggestion in ctrl.passwordSuggestions">
              <small>{{suggestion}}</small>
            </div>

          </div>

          <div ng-if="ctrl.existingUser && !ctrl.invalidPassword()" class="alert alert-danger">
            This email has already been taken. Perhaps you meant to <a id="login_link" href="/auth/users/sign_in">Sign In</a> ?
          </div>

          <div ng-if="ctrl.errorMessage && ctrl.errorMessage != ''" ng-bind-html="ctrl.errorMessage" class="alert alert-danger"></div>

          <br>

          <button class="btn btn-primary btn-block" style="margin-top: 10px;"
                  ng-click="ctrl.createAccount()"
                  ng-disabled="!ctrl.isPasswordValid() || ctrl.httpRequesting"
                  id="submit_account">
            {{ ctrl.httpRequesting ? 'Working...' : 'Continue' }}
          </button>

          <br>

          <p class="text-center diminished">
            By <strong>continuing</strong> below you agree to our
            <a target="_blank" href="https://www.nutmeg.com/legal/site-terms">Site Terms</a> and
            <a target="_blank" href="https://www.nutmeg.com/legal/privacy-policy">Privacy Policy</a>.
          </p>
        </form>
      </div>

    </div>
  </div>

</div>

    </div>

  </div>

</div>


    
  </body>
</html>
