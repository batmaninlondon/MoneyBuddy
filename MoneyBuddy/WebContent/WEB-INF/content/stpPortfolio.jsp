<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="s" uri="/struts-tags" %>


			  		<!-- Sip Summary Table Start -->
			  		
                	<div class="row" >
	             		<div class="col-md-12 col-xs-12 g-full-width--xs g-margin-b-10--xs g-bg-color--white g-box-shadow__dark-lightest-v4" >
	             			<div class="g-text-center--xs ">
	                    		<h3 class="g-font-size-16--xs g-font-size-26--md g-font-family--playfair g-letter-spacing--1 g-color--primary font-weight-bold">
	                    			Active STP's
	                   			</h3>
	                		</div>  
							
							<div  class="row  g-padding-y-0--xs g-padding-y-10--sm   ">
							<s:if test="stpDataModel.size == 0">  
								<p><b>No ongoing STPs, start one today</b></p>
							</s:if>
							<s:else>
				<s:iterator value="stpDataModel" var="stpDataModelElement" status="ctr">
						
						<div id="myDiv3" class="col-xs-12   g-bg-color--white">
							<div  class="  g-line-height--normal  ">
							<s:set var="selectedFundId" value="#stpDataModelElement.purchaseFundId" />
							
							
								<figure class="snip1419 g-height-150--xs  " style="width:100%"   >
									
				  					<!-- <figcaption > -->
				    					<article class=" panel panel-info panel-heading  g-height-80--xs " >
				    						<p class="g-color--black g-line-height--sm  g-font-size-12--xs g-font-size-16--lg " style="font-weight: bold; ">
				    						<s:property value="#stpDataModelElement.withdrawalSchemeName"/>
				    						&nbsp;&nbsp;&nbsp;&nbsp;
											
				    						</p>
				    						<p style="margin-left: 100px;font-size:30px;"><b>&#9660;</b></p>
				    						<!-- <p style="margin-left: 120px;"><b>&#8595;</b></p> -->
											 <p class="g-color--black g-line-height--sm  g-font-size-12--xs g-font-size-16--lg " style="font-weight: bold; ">
				    						<s:property value="#stpDataModelElement.purchaseSchemeName"/>
				    						&nbsp;&nbsp;&nbsp;&nbsp;
											
				    						</p>
				    						
				    					</article>
				    					<article class="g-margin-l-20--md " > 
									        <table  class="table-borderless  " cellspacing="0" width="100%">
										        <thead>
										            <tr class="g-bg-color--white g-font-family--playfair text-center " >
										                <th class="text-center" ><span class=" g-font-size-12--xs g-font-size-16--md">Folio Number</span></th>
														<th class="text-center" ><span class=" g-font-size-12--xs g-font-size-16--md">Amount</span></th>
														<th class="text-center" ><span class=" g-font-size-12--xs g-font-size-16--md">Debit Date</span></th>
										            </tr>
										        </thead>
										         <tbody>
										            <tr class="g-font-family--playfair g-bg-color--white g-font-size-12--xs g-font-size-16--lg text-center" >
										                <td class="text-center " ><span class=" ">
									                		<s:property value="#stpDataModelElement.folioNumber"/>
									                		</span></td>
														<td class="text-center" ><span >
															<fmt:formatNumber type="number" maxFractionDigits="2">
																<s:property value="#stpDataModelElement.amount"/>
															</fmt:formatNumber>
														</span></td>
														<td class="text-center" ><span >
															<s:property value="#stpDataModelElement.nextStpDate"/>
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
