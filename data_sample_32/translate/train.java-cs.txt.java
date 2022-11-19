public DVRecord createDVRecord(HSSFSheet sheet) {FormulaPair fp = _constraint.createFormulas(sheet);return new DVRecord(_constraint.getValidationType(),_constraint.getOperator(),_errorStyle, _emptyCellAllowed, getSuppressDropDownArrow(),_constraint.getValidationType()==ValidationType.LIST && _constraint.getExplicitListValues()!=null,_showPromptBox, _prompt_title, _prompt_text,_showErrorBox, _error_title, _error_text,fp.getFormula1(), fp.getFormula2(),_regions);}
public boolean atMinValue() {return value == minValue;}
public UpdateLifecyclePolicyResult updateLifecyclePolicy(UpdateLifecyclePolicyRequest request) {request = beforeClientExecution(request);return executeUpdateLifecyclePolicy(request);}
public JapaneseTokenizerFactory(Map<String,String> args) {super(args);mode = Mode.valueOf(get(args, MODE, JapaneseTokenizer.DEFAULT_MODE.toString()).toUpperCase(Locale.ROOT));userDictionaryPath = args.remove(USER_DICT_PATH);userDictionaryEncoding = args.remove(USER_DICT_ENCODING);discardPunctuation = getBoolean(args, DISCARD_PUNCTUATION, true);discardCompoundToken = getBoolean(args, DISCARD_COMPOUND_TOKEN, true);nbestCost = getInt(args, NBEST_COST, 0);nbestExamples = args.remove(NBEST_EXAMPLES);if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameters: " + args);}}
public UntagStreamResult untagStream(UntagStreamRequest request) {request = beforeClientExecution(request);return executeUntagStream(request);}
public GetIdentityPoolConfigurationResult getIdentityPoolConfiguration(GetIdentityPoolConfigurationRequest request) {request = beforeClientExecution(request);return executeGetIdentityPoolConfiguration(request);}
public String resolveNameXText(NameXPtg n) {return _iBook.resolveNameXText(n.getSheetRefIndex(), n.getNameIndex());}
public CreateDBParameterGroupRequest(String dBParameterGroupName, String dBParameterGroupFamily, String description) {setDBParameterGroupName(dBParameterGroupName);setDBParameterGroupFamily(dBParameterGroupFamily);setDescription(description);}
public XPathTokenAnywhereElement(String tokenName, int tokenType) {super(tokenName);this.tokenType = tokenType;}
@Override public int lastIndexOf(Object object) {Slice slice = this.slice;Object[] snapshot = elements;slice.checkConcurrentModification(snapshot);int result = CopyOnWriteArrayList.lastIndexOf(object, snapshot, slice.from, slice.to);return (result != -1) ? (result - slice.from) : -1;}
public UpdateQualificationTypeResult updateQualificationType(UpdateQualificationTypeRequest request) {request = beforeClientExecution(request);return executeUpdateQualificationType(request);}
public UpdateStackResult updateStack(UpdateStackRequest request) {request = beforeClientExecution(request);return executeUpdateStack(request);}
public boolean requiresCommitBody() {return true;}
public DescribeAccountModificationsResult describeAccountModifications(DescribeAccountModificationsRequest request) {request = beforeClientExecution(request);return executeDescribeAccountModifications(request);}
public void write(int oneByte) throws IOException {write(new byte[] { (byte) oneByte }, 0, 1);}
public DeleteLaunchConfigurationResult deleteLaunchConfiguration(DeleteLaunchConfigurationRequest request) {request = beforeClientExecution(request);return executeDeleteLaunchConfiguration(request);}
public String toString() {return "{"+precedence+">=prec}?";}
public GetStreamingDistributionResult getStreamingDistribution(GetStreamingDistributionRequest request) {request = beforeClientExecution(request);return executeGetStreamingDistribution(request);}
public int doLogic() throws Exception {if (name==null || value==null) {throw new Exception(getName()+" - undefined name or value: name="+name+" value="+value);}getRunData().getConfig().set(name,value);return 0;}
public DescribeDomainsResult describeDomains() {return describeDomains(new DescribeDomainsRequest());}
public CreateBackupResult createBackup(CreateBackupRequest request) {request = beforeClientExecution(request);return executeCreateBackup(request);}
public String toString() {StringBuilder buffer = new StringBuilder();buffer.append(" [FEATURE SMART TAGS]\n");buffer.append(" [/FEATURE SMART TAGS]\n");return buffer.toString();}
public RemoveUserFromGroupRequest(String groupName, String userName) {setGroupName(groupName);setUserName(userName);}
public DeleteLexiconResult deleteLexicon(DeleteLexiconRequest request) {request = beforeClientExecution(request);return executeDeleteLexicon(request);}
public UpdateInstanceRequest() {super("Ots", "2016-06-20", "UpdateInstance", "ots");setMethod(MethodType.POST);}
public NotImplemented(String functionName) {_functionName = functionName;}
public CreateUserInfoRequest() {super("cr", "2016-06-07", "CreateUserInfo", "cr");setUriPattern("/users");setMethod(MethodType.PUT);}
public DeleteConfigurationSetEventDestinationResult deleteConfigurationSetEventDestination(DeleteConfigurationSetEventDestinationRequest request) {request = beforeClientExecution(request);return executeDeleteConfigurationSetEventDestination(request);}
public static BOFRecord createSheetBOF() {return new BOFRecord(TYPE_WORKSHEET);}
public static String format(String rawSheetName) {StringBuilder sb = new StringBuilder((rawSheetName == null ? 0 : rawSheetName.length()) + 2);appendFormat(sb, rawSheetName);return sb.toString();}
public UpdateTypedLinkFacetResult updateTypedLinkFacet(UpdateTypedLinkFacetRequest request) {request = beforeClientExecution(request);return executeUpdateTypedLinkFacet(request);}
public UpdateMemberResult updateMember(UpdateMemberRequest request) {request = beforeClientExecution(request);return executeUpdateMember(request);}
