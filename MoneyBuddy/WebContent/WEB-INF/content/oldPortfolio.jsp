<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="s" uri="/struts-tags" %>


			  		<!-- Sip Summary Table Start -->
			  		
                	<div class="row" >
	             		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-10--xs g-bg-color--white g-box-shadow__dark-lightest-v4" >
	             			<div class="g-text-center--xs ">
	                    		<h3 class="g-font-size-16--xs g-font-size-26--md g-font-family--playfair g-letter-spacing--1 g-color--primary font-weight-bold">
	                    			Non MoneyBuddy Funds
	                   			</h3>
	                		</div>  
							
							<div  class="row  g-padding-y-0--xs g-padding-y-10--sm   ">
							<s:if test="oldPortfolioDataModel.size == 0">  
								<p><b>You can also track your non MoneyBuddy investments with us</b></p>
							</s:if>
							<s:else>
				<s:iterator value="oldPortfolioDataModel" var="oldPortfolioDataModelElement" status="ctr">
						
						<div id="myDiv3" class="col-xs-12   g-bg-color--white">
							<div  class="  g-line-height--normal  ">
							<s:set var="selectedFundId" value="#oldPortfolioDataModelElement.fundId" />
							
							
								<figure class="snip1419 g-height-130--xs  " style="width:100%"   >
									
				  					<!-- <figcaption > -->
				    					<article class=" panel panel-info panel-heading  g-height-60--xs " >
				    						<p class="g-color--black g-line-height--sm  g-font-size-12--xs g-font-size-16--lg " style="font-weight: bold; ">
				    						<s:property value="#oldPortfolioDataModelElement.schemeName"/>
				    						&nbsp;&nbsp;&nbsp;&nbsp;
											
				    						</p>
				    						
											  <p class="g-color--black g-line-height--lg  g-font-size-10--xs g-font-size-12--lg" >
											 	<b>Folio Number:</b> <s:property value="#oldPortfolioDataModelElement.folioNumber"/>
										 	</p>
				    						
				    					</article>
				    					<article class="g-margin-l-20--md " > 
									        <table  class="table-borderless  " cellspacing="0" width="100%">
										        <thead>
										            <tr class="g-bg-color--white g-font-family--playfair text-center " >
										                <th class="text-center" ><span class=" g-font-size-12--xs g-font-size-16--md">Investment</span></th>
														<th class="text-center" ><span class=" g-font-size-12--xs g-font-size-16--md">Value</span></th>
														<th class="text-center" ><span class=" g-font-size-12--xs g-font-size-16--md">Profit</span></th>
														<th class="text-center" ><span class=" g-font-size-12--xs g-font-size-16--md">Units</span></th>
										            </tr>
										        </thead>
										         <tbody>
										            <tr class="g-font-family--playfair g-bg-color--white g-font-size-12--xs g-font-size-16--lg text-center" >
										                <td class="text-center " ><span class=" ">
									                		<fmt:formatNumber type="number" maxFractionDigits="2">
									                			<s:property value="#oldPortfolioDataModelElement.investedAmount"/>
								                			</fmt:formatNumber>
								                		</span></td>
														<td class="text-center" ><span >
															<fmt:formatNumber type="number" maxFractionDigits="2">
																<s:property value="#oldPortfolioDataModelElement.currentValue"/>
															</fmt:formatNumber>	
														</span></td>
														<td class="text-center" ><span >
															<s:if test="#oldPortfolioDataModelElement.profit.equals('NA'.toString())">
																<s:property value="#oldPortfolioDataModelElement.profit"/>
															</s:if>
															<s:else>
																<fmt:formatNumber type="number" maxFractionDigits="2">
																	<s:property value="#oldPortfolioDataModelElement.profit"/>
																</fmt:formatNumber>
															</s:else>	
														</span></td>
														<td class="text-center" ><span >
															<fmt:formatNumber type="number" maxFractionDigits="2">
																<s:property value="#oldPortfolioDataModelElement.unitsHeld"/>
															</fmt:formatNumber>	
														</span></td>
										            </tr>
										        </tbody>
										    </table>
									       	</article>
									       	
				  				 
								</figure>
								
							</div>
						</div>
			</s:iterator> 
			</s:else>
		</div>
		              	</div>
	             	</div>
