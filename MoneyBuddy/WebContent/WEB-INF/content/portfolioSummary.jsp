<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="s" uri="/struts-tags" %>


			  								  		<!--  Portfolio Summary Table Start -->
                
                <div class="row" style=" margin: 10px 2px 20px 2px;">
             		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-10--xs g-bg-color--white g-box-shadow__dark-lightest-v4" >
             			<div class="g-text-center--xs ">
                    		<p class=" g-font-size-16--xs g-font-size-26--md g-font-family--playfair g-letter-spacing--1 g-color--primary font-weight-bold">
                    			Portfolio Details
                    		</p>
                		</div> 
							
							<div  class="row  g-padding-y-0--xs g-padding-y-10--sm   ">
							<s:if test="portfolioDataModel.size == 0">  
								<p><b>Start saving for your goals</b></p>
							</s:if>
							<s:else>
				<s:iterator value="portfolioDataModel" var="portfolioDataModelElement" status="ctr">
						
						<div id="myDiv3" class="col-xs-12 col-md-12  g-bg-color--white">
							<div  class="  g-line-height--normal  ">
							<s:set var="selectedFundId" value="#portfolioDataModelElement.fundId" />
							
							
								<figure class="snip1419 g-height-150--xs g-height-150--lg " style="width:100%"   >
									
				  					<!-- <figcaption > -->
				    					<article class=" panel panel-info panel-heading  g-height-60--xs " >
				    						<p class="g-color--black g-line-height--sm  g-font-size-12--xs g-font-size-16--lg " style="font-weight: bold; ">
				    						<s:property value="#portfolioDataModelElement.schemeName"/>
				    						&nbsp;&nbsp;&nbsp;&nbsp;
											
				    						</p>
				    						
											 <p class="g-color--black g-margin-t-10--xs g-line-height--lg  g-font-size-10--xs g-font-size-12--lg" ><b>Folio Number:</b> <s:property value="#portfolioDataModelElement.folioNumber"/></p>
				    						
				    					</article>
				    					<article class="g-margin-l-20--md " > 
									        <table  class="table-borderless g-margin-b-10--xs " cellspacing="0" width="100%">
										        <thead>
										            <tr class="g-bg-color--white g-font-family--playfair text-center " >
										                <th class="text-center" ><span class=" g-font-size-12--xs g-font-size-16--md">Investment</span></th>
														<th class="text-center" ><span class=" g-font-size-12--xs g-font-size-16--md">Value</span></th>
														<th class="text-center" ><span class=" g-font-size-12--xs g-font-size-16--md">Profit</span></th>
														<th class="text-center" ><span class=" g-font-size-12--xs g-font-size-16--md">Growth(%)</span></th>
										            </tr>
										        </thead>
										         <tbody>
										            <tr class="g-font-family--playfair g-bg-color--white g-font-size-12--xs g-font-size-16--lg text-center" >
										                <td class="text-center " ><span class=" ">
										                	<fmt:formatNumber type="number" maxFractionDigits="2">
										                		<s:property value="#portfolioDataModelElement.investedAmount"/>
									                		</fmt:formatNumber>
									                		</span></td>
														<td class="text-center" ><span >
															<fmt:formatNumber type="number" maxFractionDigits="2">
																<s:property value="#portfolioDataModelElement.currentAmount"/>
															</fmt:formatNumber>
														</span></td>
														<td class="text-center" ><span >
															<s:if test="#portfolioDataModelElement.profit.equals('NA'.toString())">
																<s:property value="#portfolioDataModelElement.profit"/>
															</s:if>
															<s:else>
																<fmt:formatNumber type="number" maxFractionDigits="2">
																	<s:property value="#portfolioDataModelElement.profit"/>
																</fmt:formatNumber>
															</s:else>
														</span></td>
														<td class="text-center" ><span >
															<s:if test="#portfolioDataModelElement.rateOfGrowth.equals('NA'.toString())">
																<s:property value="#portfolioDataModelElement.rateOfGrowth"/>
															</s:if>
															<s:else>
																<fmt:formatNumber type="number" maxFractionDigits="2">
																	<s:property value="#portfolioDataModelElement.rateOfGrowth"/>
																</fmt:formatNumber>
															</s:else>
														</span></td>
										            </tr>
										        </tbody>
										    </table>
										     <select name="select-transact"
											onchange="buyFund(<s:property value="#portfolioDataModelElement.fundId"/>,<s:property value="#portfolioDataModelElement.folioNumber"/>,<s:property value="#portfolioDataModelElement.currentAmount"/>,<s:property value="#portfolioDataModelElement.units"/>)" 
											id="transact-value-<s:property value="#portfolioDataModelElement.fundId"/>-<s:property value="#portfolioDataModelElement.folioNumber"/>" 
											class="g-margin-r-20--xs g-pull-right--xs g-color--primary g-font-size-12--xs g-font-size-14--lg g-width-80--xs g-width-90--lg"  > 
										        <option value="Transact" selected >Transact</option>
										        <option value="TopUp"  >TopUp</option>
										        <option value="Redeem" >Redeem</option>
										        <option value="STP" >STP</option>
											</select>
											
									       	</article>
									       	
		  						 <a href="#"></a>
								</figure>
								
							</div>
						</div>
			</s:iterator> 
			</s:else>
		</div>	
	              		</div>
                	</div>   
                <!-- Portfolio Summary Table End -->