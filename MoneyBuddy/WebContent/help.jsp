<!DOCTYPE html >
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Help | Money Buddy</title>
    <!-- core CSS -->
	<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
 	<link href="assets/bootstrap/css/font-awesome.min.css" rel="stylesheet">
    <link href="assets/bootstrap/css/animate.min.css" rel="stylesheet">
    <link href="assets/bootstrap/css/prettyPhoto.css" rel="stylesheet">
    <link href="assets/bootstrap/css/main.css" rel="stylesheet">
    <link href="assets/bootstrap/css/responsive.css" rel="stylesheet">
	<script type="text/javascript" src="assets/js/javaScript.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
	<script>window.Modernizr || document.write('<script src="assets/js/vendor/modernizr.min.js"><\/script>');</script>
 	<script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/jquery.prettyPhoto.js"></script>
    <script src="assets/js/jquery.isotope.min.js"></script>
    <script src="assets/js/main.js"></script>
    <script src="assets/js/wow.min.js"></script>
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    
   <style type="text/css">
            h2.frq-main-title{
               font-size: 15px;
            }
            .hrf-entry{
               margin-bottom: 0px !important;
               padding-bottom: 0px !important;
               border-bottom:1px solid #e9eaeb;
            }
            .hrf-content{
               display:none;
               color: #444444;
               background: ffffff;
               font-size: 15px;
               padding: 10px 0;
               word-break: normal;
            }
            h3.hrf-title{
               font-size: 15px ;
               color: #444444;
               background: #ffffff;
               padding: 10px 0;
               margin: 0;
               -webkit-touch-callout: none;
               -webkit-user-select: none;
               -khtml-user-select: none;
               -moz-user-select: none;
               -ms-user-select: none;
               user-select: none;
               outline-style:none;
            }
            .hrf-title.close-faq{
               cursor: pointer;
            }
            .hrf-title.close-faq span{
               width: 30px;
               height: 30px;
               display: block;
               position: relative;
               right: 0;
               float:right;
               top: 0;
               margin-right: -8px;
               margin-left: -42px;
            }
            }.hrf-title.open-faq{
            
            }
            .hrf-title.open-faq span{
               width: 30px;
               height: 30px;
               display: block;
               position: relative;
               right: 0;
               float:right;
               top: 0;
               margin-right: -8px;
               margin-left: -42px;
            }
            .hrf-entry p{
            
            }
            .hrf-entry ul{
            
            }
            .hrf-entry ul li{
            
            }</style> 
         
         
         <script>
         jQuery(function($){
        	   $(document).ready(function(){
        	      
        	      $('.hrf-title').click(function(){
        	         var my_content_id = $(this).attr('data-content-id');
        	         $('#' + my_content_id ).slideToggle();
        	         $(this).toggleClass(function(){
        	            if( $(this).is('.close-faq')){
        	               return 'open-faq';
        	            }else{
        	               return 'close-faq';
        	            }
        	            
        	         });
        	      }); //.hrf-title click
        	   });

        	});
         
         
         </script>   
           
</head>

<body class="homepage">
   <header id="header">
        <div class="top-bar">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-xs-4">
                        <div class="top-number"><p><i class="fa fa-phone-square"></i>  +91 9971648736</p></div>
                    </div>
                    <div class="col-sm-6 col-xs-8">
                       <div class="social">
                            <ul class="social-share">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-linkedin"></i></a></li> 
                                <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                <li><a href="#"><i class="fa fa-skype"></i></a></li>
                            </ul>
                       </div>
                    </div>
                </div>
            </div><!--/.container-->
        </div><!--/.top-bar-->

        <nav class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html"><img src="images/logo.png" alt="logo"></a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li><a href="myIndex">Home</a></li>
                        <li><a href="whyInvest">Why Invest</a></li>
                        <li><a href="aboutUs">About Us</a></li>
                        <li><a href="saveTax">Save Tax</a></li>
                        <li><a href="blog">Blog</a></li> 
                        <li class="active"><a href="help">Help</a></li> 
                        
				         	<%  if(session.getAttribute("customerId") == null)
							 	{   %> 
										 	 <li><a href="login" >Sign in</a></li>
										<li><a href="register" >Sign up</a></li> 
							<%	} else 
							 	{	%>
							 			 <li><a href="bseDashboard" >Dashboard</a></li> 
							 			 <li><a href="logOff" >Log Out</a></li> 
							<%	}	%>  
				                            
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header>


 <article id="post-44" class="post-44 page type-page status-publish hentry">
	
	<div class="entry-content">
		<section class="hero hero-faqs">
    <div class="container">
      <div class="col-lg-6 col-md-5 col-sm-5 col-xs-12 p0">
      </div>
      <div class="col-lg-7 col-md-7 col-sm-7 col-xs-12 p0"></div>
    </div>
  </section>

  <section class="stripe-white">
    <div class="container">
      <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 p0">

        <div class="faqs-sidebar">
          <a href="#faq-group-1" ><h4><span>1. </span>Investments</h4></a>
          <a href="#faq-group-2" id="faq-side-2"><h4><span>2. </span>ISA</h4></a>
          <a href="#faq-group-3" id="faq-side-3"><h4><span>3. </span>Profiling</h4></a>
          <a href="#faq-group-4" id="faq-side-4"><h4><span>4. </span>ETFs</h4></a>
          <a href="#faq-group-5" id="faq-side-5"><h4><span>5. </span>Fees</h4></a>
          <a href="#faq-group-6" id="faq-side-6"><h4><span>6. </span>Funding your Account</h4></a>
          <a href="#faq-group-7" id="faq-side-7"><h4><span>7. </span>Withdrawing from your Account</h4></a>
          <a href="#faq-group-8" id="faq-side-8"><h4><span>8. </span>Terms of Service</h4></a>
          <a href="#faq-group-9" id="faq-side-9"><h4><span>9. </span>Security</h4></a>
        </div>
      </div>
      <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 p0">
        <div class="faqs-list">

<h4 id="id="faq-group-1">1. Investments</h4>
<div class="hrf-faq-list"><article class="hrf-entry" id="hrf-entry-12504">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12504"><span></span><b>How much do I have to invest with Moneyfarm?</b></h3>
                     <div class="hrf-content" id="hrf-content-12504">There is no minimum level of investment to open an account with Moneyfarm. You can start from £1 and top up as much as you want.

We suggest to invest at least £1500 so that you have an optimally balanced portfolio. 

To be assigned a portfolio the minimum investment is £1. However, if your initial lump sum investment is lower than £1500 we will suggest you top-up either with a regular payment or an additional lump sum.

Having an amount under £1500 would mean that the asset allocation of the portfolio will not be balanced and the risk level may not match your investor profile. 
</div>
                  </article><article class="hrf-entry" id="hrf-entry-12505">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12505"><span></span><b>Can I add or remove cash from my initial investment?</b></h3>
                     <div class="hrf-content" id="hrf-content-12505">Yes, you can always increase or decrease the invested amount, but don’t forget that your portfolio is tied to your objective. So it’s always best to contact us if you would like to move a large amount of money.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12525">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12525"><span></span><b>Can I customise the suggested portfolio?</b></h3>
                     <div class="hrf-content" id="hrf-content-12525">No, at the moment we only offer a discretionary service. You can ask for a different portfolio from the one advised but we always suggest to speak to one of our advisors first.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12527">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12527"><span></span><b>What stops me from copying your portfolios and doing it myself?</b></h3>
                     <div class="hrf-content" id="hrf-content-12527">Nothing. You could replicate our portfolios on your own brokerage account, but rebalancing and monitoring your portfolio takes time and effort. You would also be subject to additional trading fees thereby potentially reducing your returns over time.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12528">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12528"><span></span><b>Do you give investment advice?</b></h3>
                     <div class="hrf-content" id="hrf-content-12528">Yes. Although we also manage your investments. Initially, you will be asked a series of questions to determine your knowledge, experience, risk appetite and objectives (amongst other factors). We then recommend an investment portfolio which is in keeping with the factors in your profile. This constitutes the provision of investment advice (as we take your personal circumstances into account in providing you with a recommendation). Once you select the portfolio, Moneyfarm is a discretionary investment manager. This means that once you have taken the decision to invest in the recommended portfolio with Moneyfarm, our investment team makes decisions to buy and sell your investments on your behalf. We will always bear in mind your objectives and risk profile. You do not have to give your consent for every transaction; instead, you agree that we’ll take responsibility for your investments when you accept our Terms and Conditions. We manage your account with experience, care and in accordance with the information you give us. Our goals are totally aligned to yours and our service is completely unbiased.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12530">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12530"><span></span><b>What is a model portfolio?</b></h3>
                     <div class="hrf-content" id="hrf-content-12530">A Model Portfolio is a theoretical approach that is used by the portfolio management team as a basis for your asset allocation. Your investments will therefore be managed following the model portfolio that suits your profile, having assessed your risk appetite and investment goals. For smaller investment amounts (below £3,000), the composition of your portfolio may differ from the model. Please contact us if you would like to know more.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12531">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12531"><span></span><b>How is the performance of my portfolio calculated?</b></h3>
                     <div class="hrf-content" id="hrf-content-12531">We calculate portfolio performance using a money-weighted calculation, this is in-line with international standards. This calculation represents the actual performance, taking into account any cash flows; these could be dividends, account top-ups or disinvestments. That means if you were to invest, or indeed disinvest, an amount from your portfolio this would impact the performance number. 
<br/>
Technically speaking your performance corresponds to a well-known concept in finance called the internal rate of return (IRR) of an investment. We compute the IRR of your portfolio every day, this starts from the day your first investment was made. Since this is an industry standard it enables you to compare performance easily to make our service as transparent as possible.
<br/>
On our demo portfolios we use a time-weighted calculation. If you invest a certain amount and never add more money, or disinvest, time-weighted and money-weighted performance would be the same. This is why time-weighted works for the demo portfolio.

</div>
                  </article><article class="hrf-entry" id="hrf-entry-12532">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12532"><span></span><b>Can I use Moneyfarm if I am not a UK resident?</b></h3>
                     <div class="hrf-content" id="hrf-content-12532">Currently we can only open accounts for individuals over the age of 18 living in the UK or Italy. If you have any questions regarding this please contact us via email or telephone.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12534">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12534"><span></span><b>I am a US Citizen, can I invest with Moneyfarm?</b></h3>
                     <div class="hrf-content" id="hrf-content-12534">Yes, provided you are a UK resident. Moneyfarm is FATCA compliant and a registered FFI with the U.S. Internal Revenue Service. As a US Citizen you will be asked to provide a FATCA self-certification form: please refer to the <a href="https://www.moneyfarm.com/uk/fatca" target="_blank">FATCA FAQs</a> section for more information. Always seek advice from your tax advisor to understand the implications of investing whilst living abroad.</div>
                  </article></div>
<h4 id="faq-group-2">2. ISA</h4>
<div class="hrf-faq-list"><article class="hrf-entry" id="hrf-entry-12538">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12538"><span></span><b>What is an ISA?</b></h3>
                     <div class="hrf-content" id="hrf-content-12538">An Individual Savings Account (ISA) is a form of investment created by the UK government that gives you a tax-free allowance. There are two main types of ISAs: Cash ISAs and Stocks and Shares ISAs. You can only pay into one Stocks and Shares ISA and one Cash ISA in each tax year, but you can open a new ISA with a different provider each year if you want to.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12540">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12540"><span></span><b>How much is the ISA allowance?</b></h3>
                     <div class="hrf-content" id="hrf-content-12540">Every tax year runs from 6 April until 5 April of the following year. The government can change the ISA allowance every year.
<br><br>
This tax year you are allowed to put up to £20,000 into your ISA.
<br><br>
<strong>Current Tax Year (2017/2018) — £20,000</strong><br>
Previous Tax Year (2016/2017) — £15,240<br>
Earlier Tax Year (2015/2016) – £15,000<br>
<br><br>
You can pay your whole allowance of £20,000 into a Stocks and shares ISA, a Cash ISA, or a combination of these. So even if you have a Cash ISA elsewhere, you can still open a Stocks and Shares ISA with Moneyfarm.
<br><br>
You can choose between making a lump sum investment and/or making regular or ad hoc contributions throughout the tax year.
<br><br>
Your yearly ISA allowance expires at the end of the tax year and any unused allowance will be lost. It can’t be rolled over to the following year.
<br><br>
With MoneyFarm you can invest more than the ISA allowance but any investments outside the ISA allowance will not be sheltered from tax.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12542">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12542"><span></span><b>Can I withdraw from my ISA?</b></h3>
                     <div class="hrf-content" id="hrf-content-12542">You can take money out of your Moneyfarm ISA whenever you want. When you do this it will not impact your ISA allowance from that tax year. 

From 6th April 2016 you can take money out of a Cash ISA or a Stocks and Shares ISA and put it back in without losing that part of your allowance, provided you put it back in the same tax year.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12544">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12544"><span></span><b>What are the requisites to open an ISA?</b></h3>
                     <div class="hrf-content" id="hrf-content-12544">To open a Stocks and Shares ISA you must be at least 18 years old and must be a UK resident for tax purposes.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12545">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12545"><span></span><b>What are the tax benefits of an ISA?</b></h3>
                     <div class="hrf-content" id="hrf-content-12545">Any gains made by selling investments within your Stocks and Shares ISA are not subject to capital gains tax. 

Any losses made on your investments in your Stocks and Shares ISAs can’t be used to offset capital gains on your other investments. Remember, there is an annual Capital Gains Tax exemption amount (£11,100 for the 2017/18 tax year) which you can claim on your annual tax return.

If you’re likely to make capital gains of more than this, you’ll benefit from using an ISA. Investments that pay interest (e.g. government and corporate bonds), or rental income (such as some property funds) provide 100% tax-free income if held within an ISA and therefore offer tax benefits for everyone. 

Outside of an ISA, you don’t pay tax on the first £5,000 of dividends you get in the tax year. Above this allowance, you pay tax of 7.5-38.1%, depending on your income tax band. Dividends that fall within your personal allowance don’t count towards your £5,000 allowance. 

The tax treatment of a Moneyfarm Stocks and Shares ISA depends on your individual circumstances and may be subject to change in the future.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12546">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12546"><span></span><b>Do you offer a Cash ISA?</b></h3>
                     <div class="hrf-content" id="hrf-content-12546">No, we currently only offer a Stocks and Shares ISA. We are an investment manager so will be primarily focus our work on providing the best possible Stocks and Shares ISA to our customers.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12547">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12547"><span></span><b>Do you offer a help-to-buy ISA?</b></h3>
                     <div class="hrf-content" id="hrf-content-12547">No, the help-to-buy ISA is currently a Cash ISA, not a Stocks and Shares ISA. The government has said that help-to-buy ISAs will be made available through banks and building societies. Despite this we are reviewing all regulations surrounding the help-to-buy ISA scheme in detail and will let you know if anything changes. </div>
                  </article><article class="hrf-entry" id="hrf-entry-12548">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12548"><span></span><b>Do you offer a Junior ISA?</b></h3>
                     <div class="hrf-content" id="hrf-content-12548">No, not at this current time. We hope to bring a junior ISA to our customers in the near future but for now we do not offer this type of account. Please keep an eye on our mailings for indication to when we will be releasing the Junior ISA.</div>
                  </article></div>
<h4 id="faq-group-2b">ISA Transfer</h4>
<div class="hrf-faq-list"><article class="hrf-entry" id="hrf-entry-12549">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12549"><span></span><b>Can I transfer existing ISAs with other providers to the MoneyFarm ISA?</b></h3>
                     <div class="hrf-content" id="hrf-content-12549">Yes. You can transfer existing ISAs from other providers by simply completing a <a href="https://www.moneyfarm.com/uk/wp-content/uploads/2016/12/Moneyfarm-ISA-Transfer.pdf">MoneyFarm ISA transfer form</a>.
This should be returned to us and we will then contact your existing ISA provider to arrange the transfer.

It will be possible to transfer both Cash ISAs and Stocks &#038; Shares ISAs to MoneyFarm, however we will always hold your investments in a Stocks &#038; Shares ISA. We do not currently offer a Cash ISA.

Any Stocks and Shares ISA that is transferred won’t hold the same investments as before. We instruct the current ISA manager to sell the investments and transfer the ISA as cash for us to invest. This preserves your ISA’s tax-efficient status and allows us to manage it in the most appropriate way for your goals, timeframe and attitude to risk.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12552">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12552"><span></span><b>If I transfer an ISA will it count towards my ISA allowance?</b></h3>
                     <div class="hrf-content" id="hrf-content-12552">ISA transfers do not count towards your annual ISA allowance.

Any additional savings or investments you make within the tax year on top of your existing ISA savings and investments, will count towards your annual allowance for the tax year.

An ISA transfer does not count as a new ISA subscription, so if you are transferring ISAs from previous tax years, this has no impact on your ISA allowance for the current tax year.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12555">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12555"><span></span><b>How much of my ISA can I transfer?</b></h3>
                     <div class="hrf-content" id="hrf-content-12555">It is possible to transfer all or only part of your ISA allowance to a different provider.
However, if you have already made an ISA subscription for the current tax year, and wish to transfer that money to a new provider, you will have to transfer the total ISA.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12556">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12556"><span></span><b>How long does it take to transfer an ISA?</b></h3>
                     <div class="hrf-content" id="hrf-content-12556">Once your Moneyfarm ISA transfer form is received, we’ll work with your current provider to transfer your ISA to our service – safely and securely. This normally takes between 15 and 30 days, but is completely dependent on your current provider. </div>
                  </article><article class="hrf-entry" id="hrf-entry-12558">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12558"><span></span><b>When can I transfer my ISA?</b></h3>
                     <div class="hrf-content" id="hrf-content-12558">You can transfer an ISA at any time, and you can transfer as often as you like. Remember, if you have saved into a fixed rate Cash ISA there may be a penalty if you transfer before the end of the fixed term.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12560">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12560"><span></span><b>How do I transfer my ISA investments to another manager?</b></h3>
                     <div class="hrf-content" id="hrf-content-12560">If you would like to transfer your investments to another manager, please contact them and ask them to arrange the transfer with us.

Please be aware of the following:
<ul>
 	<li>We cannot transfer your holdings as funds, only cash.</li>
 	<li>In accordance with this, all assets will be liquidated within 7 days upon your request to transfer.</li>
 	<li>There is no dealing commission charged when we sell your funds.</li>
 	<li>There will be no charge for closing your account with us.</li>
</ul></div>
                  </article></div>
<h4 id="faq-group-3">3. Profiling</h4>
<div class="hrf-faq-list"><article class="hrf-entry" id="hrf-entry-12562">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12562"><span></span><b>How do you understand my attitude to risk?</b></h3>
                     <div class="hrf-content" id="hrf-content-12562">We developed a questionnaire based algorithm that measures your financial risk aversion, and combines it with other psychological characteristics that influence your relationship with investments e.g. anxiety, confidence, auto control etc. The final result will be your risk profile which will be assigned to one of our 6 profiles available.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12564">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12564"><span></span><b>Why do you need to assess my risk profile?</b></h3>
                     <div class="hrf-content" id="hrf-content-12564">Your risk profile represents you as an investor in terms of your risk aversion, income and financial situation. By profiling you we can understand your characteristics, give you a better advice and optimise your portfolio by suggesting the one that would suit you the best.</div>
                  </article></div>
<a name="faq-group-4"></a>
<h4 id="faq-group-4">4. ETFs</h4>
<div class="hrf-faq-list"><article class="hrf-entry" id="hrf-entry-12570">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12570"><span></span><b>What is an ETF?</b></h3>
                     <div class="hrf-content" id="hrf-content-12570">An Exchange Traded Fund (ETF) is an investment fund, traded like shares, which hold assets such as shares, commodities or bonds. They normally closely track the performance of a financial index, and as such, their value can go down as well as up and you may get back less than you originally invested. </div>
                  </article><article class="hrf-entry" id="hrf-entry-12572">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12572"><span></span><b>Why do you use ETFs?</b></h3>
                     <div class="hrf-content" id="hrf-content-12572">ETFs are a great instrument to pursue our long-term investment strategy. They are low-cost, transparent, liquid and provide a native diversification that enables us to create an optimally diversified portfolio even with low capital.

A passive approach is by far the best strategy for an investor and ETFs represent the best tool for indexing and building the right asset allocation mix.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12573">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12573"><span></span><b>How do you select ETFs?</b></h3>
                     <div class="hrf-content" id="hrf-content-12573">Moneyfarm evaluates thousands of ETFs for optimal investments based on low cost, tax efficiency, and stock-like features. We look for ETFs with the lowest annual expense ratios, minimal tracking error, and sufficient liquidity. Unfortunately, many investors only focus on cost and end up with an ETF that doesn’t track its benchmark well. This defeats the purpose of optimising the mix of asset classes.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12574">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12574"><span></span><b>Are ETFs secure?</b></h3>
                     <div class="hrf-content" id="hrf-content-12574">Fund assets are generally held in safekeeping on investors’ behalf by a trustee or depositary.

If Moneyfarm goes into default, your assets are protected. You continue to own your investment and the fund’s assets are still invested as before.

If your money is mismanaged – for example, the fund manager invests it in something the fund shouldn’t invest in – then the firm would be required to compensate investors. If it did not have enough money and, therefore, went out of business, then the outstanding compensation would be covered by the Financial Services Compensation Scheme (FSCS) up to £50,000 per person.

You cannot claim compensation simply because the value of your investment falls. All investments involve some risk. An index tracker will lose money if the index it is tracking goes down.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12575">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12575"><span></span><b>Do ETFs come with any fees?</b></h3>
                     <div class="hrf-content" id="hrf-content-12575">ETFs are one of the most efficient ways of investing, however, they do have a small cost. On average you’ll incur a cost of 0.25% per annum deducted directly from the value of your portfolio. This is very low compared to other instruments, such as mutual funds, where this fee can be as much as 1%.

For example:
If you invest £20,000: You will be charged 0% on the first £10,000 and then 0.6% on the remaining £10,000.
This results in a total annual fee of: <strong>(0.6 x 10,000 = £60) from Moneyfarm directly</strong>.
Plus then the additional ETF charge of 0.25% (per annum) on top of the 0.6%, which will be deducted on an ongoing basis, directly from the value of your portfolio.

<strong>Please note</strong>: There will always be an inherent ongoing charge with ETFs regardless of who you invest with.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12576">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12576"><span></span><b>What is the taxation on ETFs?</b></h3>
                     <div class="hrf-content" id="hrf-content-12576">ETFs are not given special treatment in the UK. In general, when it comes to taxes, ETFs and traditional funds are treated the same. 

The most important thing to consider before buying an ETF is the country of issue. If an ETF was issued in the US or France, you may have to pay more tax on that investment than you otherwise would if you bought the ETF in the UK. Specifically France and the US have tax regimes that enforce withholding tax, which often tax’s ETF dividends at a very high rate. Dividends from ETFs domiciled in France can be subject to a 30% tax deduction at source, which is not always fully reclaimable. Dividends paid by American-based ETFs can be subject to a withholding tax of 30%. This withholding tax takes a big bite out of your investment gains.

There is an important classification system that investors should be aware of that govern taxes for ETFs.  It is very important to check an ETF’s classification before making a purchase.

Roughly 75% of ETFs in the UK are given either ‘reporting’ or ‘distributor’ status. When an ETF has either of these classifications, it means that any ETF gains are subject to capital gains tax, which is generally a cheaper alternative to income tax. Capital gains tax rates are either 18% or 28%, instead of income tax rates which can be as high as 50%. (Keep in mind, this capital gains tax is not only applied to ETFs, but to other traditional investments such as funds and shares.)

It is critical to know that roughly 25% of ETFs in the UK and most ETFs listed on US or European exchanges do not have the ‘reporting’ or ‘distributor’ status. Without this status, investment gains can be charged as income tax, which can become very expensive.

ETF gains in an ISA or another tax-efficient wrapper are generally tax-free. Wherever possible these are likely to be the most tax advantageous ways to hold ETFs. However, you have to be aware that a withholding tax can be applied if the funds are domiciled in France or the US.

MoneyFarm only uses ETFs domiciled in the UK with a ‘reporting’ or ‘distributor’ status.</div>
                  </article></div>
<h4 id="faq-group-5">5. Fees</h4>
<div class="hrf-faq-list"><article class="hrf-entry" id="hrf-entry-12577">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12577"><span></span><b>How do you calculate fees?</b></h3>
                     <div class="hrf-content" id="hrf-content-12577">The fees are as follows:
<ul>
	<li>The first £10,000 will be charged at 0%</li>
	<li>Any amount from £10,000 up to £100,000 will be charged at 0.6%.</li>
	<li>Any amount from £100,000 up to £1,000,000 will be charged at 0.4%.</li>
	<li>Any amount over £1,000,000 will be charged at 0%.</li>
</ul>

Your <strong>first £10,000 will always be managed for free</strong>. For example, if you invest £50,000 you’ll be charged only on the difference (i.e. £40,000).

Fees are charged quarterly and calculated as the sum of the daily portfolio value minus £10,000, multiplied by the annual fee, divided by 365.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12604">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12604"><span></span>What is included/excluded from the annual fee?</h3>
                     <div class="hrf-content" id="hrf-content-12604">All the costs related to an investment, disinvestment, rebalance or any kind of operation on your portfolio are included, as well as the entry and exit fees.

Funds costs are not included in the annual fee and will not appear as a charge, but is factored into the performance of your investment. Moneyfarm uses ETFs, these have a small cost payable to the ETF provider, also known as the Total Expense Ratio.This is very low compared to other instruments, such as mutual funds, where this fee can be as much as 1%. On average by investing with Moneyfarm you will incur a cost of 0.25% deducted directly from the value of your investment.

Here is what’s included:
<br><br>
<div class="compare-table">
<table>
<tbody>
<tr>
<th style="visibility:hidden !important;border:0;"></th>
<th>Moneyfarm</th>
<th>IFA’s &amp; DIY accounts</th>
</tr>
<tr>
<td>Management fee</td>
<td>Included</td>
<td>Included</td>
</tr>
<tr>
<td>Underlying funds cost</td>
<td></td>
<td></td>
</tr>
<tr>
<td>Set-up fee</td>
<td>Included</td>
<td></td>
</tr>
<tr>
<td>Trading fee</td>
<td>Included</td>
<td></td>
</tr>
<tr>
<td>Rebalancing fee</td>
<td>Included</td>
<td></td>
</tr>
<tr>
<td>Transfer fee</td>
<td>Included</td>
<td></td>
</tr>
<tr>
<td>Custodian fee</td>
<td>Included</td>
<td></td>
</tr>
<tr>
<td>Trading fee</td>
<td>Included</td>
<td></td>
</tr>
<tr>
<td>Withdrawal fee</td>
<td>Included</td>
<td></td>
</tr>
<tr>
<td>Urgent withdrawal fee</td>
<td>Included</td>
<td></td>
</tr>
<tr>
<td>Direct debit fee</td>
<td>Included</td>
<td></td>
</tr>
<tr>
<td>Platform fee</td>
<td>Included</td>
<td></td>
</tr>
<tr>
<td>Inactivity fee</td>
<td>Included</td>
<td></td>
</tr>
<tr>
<td>Subscription fee</td>
<td>Included</td>
<td></td>
</tr>
</tbody>
</table>
</div></div>
                  </article><article class="hrf-entry" id="hrf-entry-12605">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12605"><span></span>How do I pay the fees?</h3>
                     <div class="hrf-content" id="hrf-content-12605">You don’t have to do anything. If you have invested any money with Moneyfarm, we will charge you the fees automatically and deduct them from the cash held on your account. You will always have a small percentage of liquidity (Cash) within your portfolio, around 2-3%, which we will use to take the fees. Liquidity will also act as an important, optimally weighed asset class within your portfolio. </div>
                  </article><article class="hrf-entry" id="hrf-entry-12606">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12606"><span></span>Do ETFs come with any charges?</h3>
                     <div class="hrf-content" id="hrf-content-12606">ETFs are a low cost way of investing. On average you’ll incur a cost of 0.25% per annum deducted directly from the value of your portfolio. This is very low compared to other instruments, such as mutual funds, where this fee can be as much as 1.42% (<a href="http://www.theinvestmentassociation.org/assets/files/press/2016/IAInvestmentCostsPerformance.pdf" target="_blank">Investment Association</a>).

<span style="text-decoration: underline;">For example:</span>
If you invest £20,000 with Moneyfarm: You will not be charged any management fees on the first £10,000 and then you’ll be charged 0.6% on the remaining £10,000.
This results in a total annual fee of: <strong>(0.6% x 10,000 = £60) to Moneyfarm directly</strong>.
You will also be charged 0.25% (per annum) on your entire portfolio, this is separate to the 0.6% and will be deducted on an ongoing basis, directly from the value of your portfolio.

<strong>Please note</strong>: There will always be an inherent ongoing charge with ETFs regardless of who you invest with.</div>
                  </article></div>
<h4 id="faq-group-6">6. Funding your Account</h4>
<div class="hrf-faq-list"><article class="hrf-entry" id="hrf-entry-12608">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12608"><span></span>How do I add funds to my account?</h3>
                     <div class="hrf-content" id="hrf-content-12608">There are several quick and easy ways for you to make contributions to your MoneyFarm account.

If you are setting up a monthly contribution you can do this direct debit. Simply click on ‘Add funds’, select the date you would like to make the contribution and ‘Direct Debit’ as the Payment Method. If you would prefer you can set up a standing order with your bank, please call our Investment Consultants team on 0800 433 4574 if you wish to do this.

If you are setting up a one time contribution you can do this via Direct Debit or bank transfer. If you select Direct Debit you don’t have to do anything, we will debit your account the amount you select. If you select Bank Transfer you will need to manually transfer the funds to us using the reference code and bank details we provide during the setup.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12609">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12609"><span></span>Can I transfer funds from another bank account?</h3>
                     <div class="hrf-content" id="hrf-content-12609">No. Due to regulation we can only accept contributions that come from the bank account you signed up with.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12610">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12610"><span></span>How do I change the bank details linked to my account?</h3>
                     <div class="hrf-content" id="hrf-content-12610">To change the bank details you signed up with you will need to email our Investment Consultants team (support@moneyfarm.com) with any official document showing your name, sort code and account number. If is easier this can be a screenshot or a photo of the document. We don’t need to know any details of any previous transactions, you can crop these out of the document you send.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12611">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12611"><span></span>Can I use Direct Debit to make a one time payment?</h3>
                     <div class="hrf-content" id="hrf-content-12611">Yes. Although Direct Debit is most commonly used for monthly payments, you can also set up a one time Direct Debit through our platform. When you add funds simply select one time payment and Direct Debit and we will guide you through the rest.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12612">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12612"><span></span>Can I set up more than one Direct Debit?</h3>
                     <div class="hrf-content" id="hrf-content-12612">If you have multiple portfolios you can set up a separate direct debit for each one. Due to regulation all payments must come from the same bank account. If you need to change your bank account on record you can contact the Investment Consultant team and they will guide you through updating it.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12613">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12613"><span></span>When will you take the Direct Debit?</h3>
                     <div class="hrf-content" id="hrf-content-12613">For monthly contributions, we will collect the money from your bank on or around the date you chose when you set up the Direct Debit. For example, if you chose the 6th of every month we will take the payment sometime between the 4th and 8th of that month. For one time contributions we will take the payment as soon as possible.

Please note that it may take up to 6 days to set up your Direct Debit mandate, therefore your first payment will take slightly longer.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12614">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12614"><span></span>When will the funds appear in my Moneyfarm account?</h3>
                     <div class="hrf-content" id="hrf-content-12614">If you have sent funds to us via bank transfer, it normally takes 1 working day for the money to show up in your account. However some banks can take up to 2-3 working days. Once received, funds are then normally traded the next working day.

For direct debit payments (both one-off and monthly), it can take up to 4 working days for the money to show up in your account and an additional working day for the funds to be invested.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12615">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12615"><span></span>What is the Direct Debit Guarantee?</h3>
                     <div class="hrf-content" id="hrf-content-12615">Organisations using the Direct Debit Scheme go through a careful vetting process before they&#8217;re authorised, and are closely monitored by the banking industry. The efficiency and security of Direct Debit is monitored and protected by your own bank or building society.

The Direct Debit Guarantee applies to all Direct Debits. It protects you in the rare event that there is an error in the payment of your Direct Debit*.

The Guarantee is offered by all banks and building societies that accept instructions to pay Direct Debits
If there are any changes to the amount, date or frequency of your Direct Debit the organisation will notify you (normally 10 working days) in advance of your account being debited or as otherwise agreed. If you request the organisation to collect a payment, confirmation of the amount and date will be given to you at the time of the request
If an error is made in the payment of your Direct Debit, by the organisation or your bank or building society, you are entitled to a full and immediate refund of the amount paid from your bank or building society
If you receive a refund you are not entitled to, you must pay it back when the organisation asks you to
You can cancel a Direct Debit at any time by simply contacting your bank or building society. Written confirmation may be required. Please also notify the organisation.
* The Guarantee covers Direct Debit payments. It cannot be used to address contractual disputes between you and the billing organisation.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12617">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12617"><span></span>Is there a limit to how much I can deposit in my Moneyfarm account using Direct Debit?</h3>
                     <div class="hrf-content" id="hrf-content-12617">Yes. There is currently a £16,000 monthly limit if you chose to pay in via Direct Debit. If you wish to contribute larger sums on a monthly basis please set up a standing order with your bank or contact our investment consultant team to discuss.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12618">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12618"><span></span>How do I cancel a monthly Direct Debit?</h3>
                     <div class="hrf-content" id="hrf-content-12618">You can cancel a monthly Direct Debit by going to your Funding Details page. From there you can cancel a specific Direct Debit by clicking on the ‘x’ in the table.</div>
                  </article></div>
<h4 id="faq-group-7">7. Withdrawing from your Account</h4>
<div class="hrf-faq-list"><article class="hrf-entry" id="hrf-entry-13040">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-13040"><span></span>How do I withdraw from available cash?</h3>
                     <div class="hrf-content" id="hrf-content-13040">Click into the ‘Funding details’ section of your account, this can be found on the bottom tab of your mobile app, or by clicking on the arrow next to your name on the website. Click on the ‘Withdrawals request’ button, input the amount you would like to withdraw, and the bank account you would like this to be sent to. This creates a request, and the money is sent to your nominated bank account. This can take up to two working days to appear in your nominated bank account.</div>
                  </article><article class="hrf-entry" id="hrf-entry-13041">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-13041"><span></span>How long does it take to get my money back?</h3>
                     <div class="hrf-content" id="hrf-content-13041">From disinvestment through to having the money back in your nominated account it can take up to seven working days. This is a two-step process, the disinvestment can take up to five working days, and the withdrawal will not take longer than two working days.</div>
                  </article><article class="hrf-entry" id="hrf-entry-13039">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-13039"><span></span>How do I disinvest?</h3>
                     <div class="hrf-content" id="hrf-content-13039">The process differs slightly depending on whether you are doing this via the website or via the mobile app.

<em>On mobile</em>
Once you have logged into your Moneyfarm account, click into your portfolio, select edit, and then click ‘Decrease investment’. You then put in the amount you would like to withdraw, click ‘Continue’, and you’ll then see a pop-up asking you to confirm. This sends a note to our portfolio management team who will act on your request. It can take up to five working days for this money to appear in your available cash.

 
<em>On the website</em>
Once you have logged into your Moneyfarm account, click into your portfolio (the ‘Details’ button), select ‘Actions’, and then click ‘Decrease investment’. You then put in the amount you would like to withdraw, click ‘Continue’, and you’ll then see a pop-up asking you to confirm. This sends a note to our portfolio management team who will act on your request. It can take up to five working days for this money to appear in your available cash.</div>
                  </article><article class="hrf-entry" id="hrf-entry-13038">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-13038"><span></span>How do I get my money into my personal bank account?</h3>
                     <div class="hrf-content" id="hrf-content-13038">In order to get your money back into your nominated bank account the money needs to be in your available cash. That means you first need to make a disinvestment. Your money will then appear in available cash and you can either choose to add it to a new portfolio or to withdraw it and have it sent to your bank account. This will be the bank account nominated during the sign-up process.</div>
                  </article></div>
<h4 id="faq-group-8">8. Terms of Service</h4>
<div class="hrf-faq-list"><article class="hrf-entry" id="hrf-entry-12620">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12620"><span></span>Am I locked in?</h3>
                     <div class="hrf-content" id="hrf-content-12620">No, you can withdraw whenever you like without paying any additional fees. With Moneyfarm there’s no minimum investment period but keep in mind that when investing you should have a long term approach.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12621">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12621"><span></span>How can I cancel my account?</h3>
                     <div class="hrf-content" id="hrf-content-12621">Signing up is free and carries no obligation to invest. We don’t charge you anything until you transfer money into your Moneyfarm account. You can close your account and withdraw your money whenever you want. After we close your account, we hold your personal information for a time as required by law. You should always remember that investments are subject to market risk and if you do invest you may not get back the sum you invested.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12622">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12622"><span></span>I&#8217;m subject to personal account dealing rules, what happens?</h3>
                     <div class="hrf-content" id="hrf-content-12622">If you work in certain professions (e.g. financial services, consulting, legal and accounting firms or government departments) you could be subject to restrictions on the types on securities that you can invest in. These restrictions may prevent you from holding certain securities, enforce a minimum holding period, restrict trading periods, force the sale of a security and so on.

Generally, discretionary investment accounts — like the one that Moneyfarm offers — are exempt from these rules as the decisions about which underlying securities to invest in are made by the investment manager, not the individual. This usually makes your investment choice greater and your life easier, since you may no longer need to seek approval from your employer for any investment transactions made by Moneyfarm. This depends on the personal account dealing rules to which you are subject and not all employers have the same requirements.</div>
                  </article></div>
<h4 id="faq-group-9">9. Security</h4>
<div class="hrf-faq-list"><article class="hrf-entry" id="hrf-entry-12623">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12623"><span></span>Is my personal information secure with you?</h3>
                     <div class="hrf-content" id="hrf-content-12623">Your privacy is important to us. Moneyfarm takes serious precautionary measures to ensure that your personal details are held in absolute confidence. Your personal details and your account data are always encrypted and stored on secure servers.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12624">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12624"><span></span>Is Moneyfarm regulated?</h3>
                     <div class="hrf-content" id="hrf-content-12624">Yes. Moneyfarm is authorised and regulated by the <a href="https://www.fca.org.uk/" target="_blank">Financial Conduct Authority</a> (FCA) no. 629539. Details of our authorisation can be found on the Financial Services Register by clicking <a href="https://register.fca.org.uk/ShPo_FirmDetailsPage?id=001b000000aQtQkAAK" target="_blank">here</a>.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12625">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12625"><span></span>Is my money safe?</h3>
                     <div class="hrf-content" id="hrf-content-12625">As an investment firm authorised and regulated by the FCA, Moneyfarm is obligated to segregate client funds and assets. This means that your money and investments are held separately from Moneyfarm’s own bank account and cannot be mixed with our own funds.

We believe that the safest way of looking after your investments is to appoint a custodian bank which holds your money and the investments we purchase for you. We hold your money and investments using carefully selected, regulated financial institutions such as Barclays and Saxo Capital Markets UK Ltd, and we ensure that they meet the relevant criteria to keep your money safe at all times.</div>
                  </article><article class="hrf-entry" id="hrf-entry-12626">
                      <h3 class="hrf-title close-faq" data-content-id="hrf-content-12626"><span></span>What if Moneyfarm goes bust?</h3>
                     <div class="hrf-content" id="hrf-content-12626">In the unlikely event of Moneyfarm entering into administration, retail clients will have their funds and market value of assets returned to them from the client money bank account/ custodian account. As these bank accounts are held by Moneyfarm in trust for underlying clients, no other general creditor can access or make claim to the funds contained therein.

Furthermore your money and investments are eligible for compensation under the Financial Services Compensation Scheme (FSCS) for up to £50,000 if the company is unable to repay investments or money.

Compensation under the FSCS is also triggered in the event of losses arising from bad investment advice, poor investment management or misrepresentation. For further information on the FSCS please click on the following link <a href="http://www.fscs.org.uk/what-we-cover/products/investments/" target="_blank">http://www.fscs.org.uk/what-we-cover/products/investments/</a>.</div>
                  </article></div>

        </div>
      </div>
    </div>
  </section>	</div><!-- .entry-content -->

</article><!-- #post-## -->

  
      <footer id="footer" class="midnight-blue">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2013 <a target="_blank" href="http://shapebootstrap.net/" title="Free Twitter Bootstrap WordPress Themes and HTML templates">ShapeBootstrap</a>. All Rights Reserved.
                </div>
                <div class="col-sm-6">
                    <ul class="pull-right">
                        <li><a href="#">Home</a></li>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Faq</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>

<!-- row-offcanvas -->

</body>
</html>