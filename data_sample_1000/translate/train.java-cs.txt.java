public GetRegionRequest() {super("cr", "2016-06-07", "GetRegion", "cr");setUriPattern("/regions");setMethod(MethodType.GET);}
public String getNameText(NamePtg namePtg) {return _iBook.getNameRecord(namePtg.getIndex()).getNameText();}
public IndexInput clone() {return (IndexInput) super.clone();}
public ValueEval evaluate(int srcRowIndex, int srcColumnIndex) {Date now = new Date(System.currentTimeMillis());return new NumberEval(DateUtil.getExcelDate(now));}
public long getCount() {return cnt;}
public void parseLine(DocData docData, String line) {int n = 0;int k1 = 0;int k2;while ((k2 = line.indexOf(WriteLineDocTask.SEP, k1)) >= 0) {if (n>=header.length) {throw new RuntimeException("input line has invalid format: "+(n+1)+" fields instead of "+header.length+" :: [" + line + "]");}setDocDataField(docData, n, line.substring(k1,k2));++n;k1 = k2 + 1;}if (n!=header.length-1) {throw new RuntimeException("input line has invalid format: "+(n+1)+" fields instead of "+header.length+" :: [" + line + "]");}setDocDataField(docData, n, line.substring(k1));}
public String getErrorDisplay(String s) {StringBuilder buf = new StringBuilder();for (char c : s.toCharArray()) {buf.append(getErrorDisplay(c));}return buf.toString();}
public ListenerHandle addIndexChangedListener(IndexChangedListener listener) {return addListener(IndexChangedListener.class, listener);}
public BufferedIndexInput clone() {BufferedIndexInput clone = (BufferedIndexInput)super.clone();clone.buffer = null;clone.bufferLength = 0;clone.bufferPosition = 0;clone.bufferStart = getFilePointer();return clone;}
public ListGameServersResult listGameServers(ListGameServersRequest request) {request = beforeClientExecution(request);return executeListGameServers(request);}
public GetImageLayerRequest() {super("cr", "2016-06-07", "GetImageLayer", "cr");setUriPattern("/repos/[RepoNamespace]/[RepoName]/tags/[Tag]/layers");setMethod(MethodType.GET);}
public static int[] copyOf(int[] original, int newLength) {if (newLength < 0) {throw new NegativeArraySizeException();}return copyOfRange(original, 0, newLength);}
public DescribeReservedDBInstancesResult describeReservedDBInstances() {return describeReservedDBInstances(new DescribeReservedDBInstancesRequest());}
public FieldIndexEnum getFieldEnum(FieldInfo fieldInfo) {final FieldIndexData fieldData = fields.get(fieldInfo.name);if (fieldData.fst == null) {return null;} else {return new IndexEnum(fieldData.fst);}}
public void setValuesCellRange(CellRangeAddressBase range) {Integer count = setVerticalCellRange(dataValues, range);if (count == null){return;}series.setNumValues((short)(int)count);}
public SetMeRequest() {super("CloudPhoto", "2017-07-11", "SetMe", "cloudphoto");setProtocol(ProtocolType.HTTPS);}
public String toString() {StringBuilder buffer = new StringBuilder();buffer.append("[SXDI]\n");buffer.append("  .isxvdData = ").append(HexDump.shortToHex(isxvdData)).append("\n");buffer.append("  .iiftab = ").append(HexDump.shortToHex(iiftab)).append("\n");buffer.append("  .df = ").append(HexDump.shortToHex(df)).append("\n");buffer.append("  .isxvd = ").append(HexDump.shortToHex(isxvd)).append("\n");buffer.append("  .isxvi = ").append(HexDump.shortToHex(isxvi)).append("\n");buffer.append("  .ifmt = ").append(HexDump.shortToHex(ifmt)).append("\n");buffer.append("[/SXDI]\n");return buffer.toString();}
public boolean isSheetHidden(int sheetnum) {return getBoundSheetRec(sheetnum).isHidden();}
public PatternReplaceFilterFactory(Map<String, String> args) {super(args);pattern = getPattern(args, "pattern");replacement = get(args, "replacement");replaceAll = "all".equals(get(args, "replace", Arrays.asList("all", "first"), "all"));if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameters: " + args);}}
public DeleteWorkteamResult deleteWorkteam(DeleteWorkteamRequest request) {request = beforeClientExecution(request);return executeDeleteWorkteam(request);}
public static Cell translateUnicodeValues(Cell cell) {String s = cell.getRichStringCellValue().getString();boolean foundUnicode = false;String lowerCaseStr = s.toLowerCase(Locale.ROOT);for (UnicodeMapping entry : unicodeMappings) {String key = entry.entityName;if (lowerCaseStr.contains(key)) {s = s.replaceAll(key, entry.resolvedValue);foundUnicode = true;}}if (foundUnicode) {cell.setCellValue(cell.getRow().getSheet().getWorkbook().getCreationHelper().createRichTextString(s));}return cell;}
public CreateInvalidationRequest(String distributionId, InvalidationBatch invalidationBatch) {setDistributionId(distributionId);setInvalidationBatch(invalidationBatch);}
public boolean precpred(RuleContext localctx, int precedence) {return precedence >= _precedenceStack.peek();}
public RemoveTargetsResult removeTargets(RemoveTargetsRequest request) {request = beforeClientExecution(request);return executeRemoveTargets(request);}
public String toString() {return "L";}
public static int headerLength(String codec) {return 9+codec.length();}
public DescribeOrderableClusterOptionsResult describeOrderableClusterOptions() {return describeOrderableClusterOptions(new DescribeOrderableClusterOptionsRequest());}
public boolean containsColumn(int columnIndex) {return _firstCol <= columnIndex && columnIndex <= _lastCol;}
public GetSnowballUsageResult getSnowballUsage(GetSnowballUsageRequest request) {request = beforeClientExecution(request);return executeGetSnowballUsage(request);}
public final float readFloat() throws IOException {return Float.intBitsToFloat(readInt());}
public TokenStream create(TokenStream input) {return new ICUNormalizer2Filter(input, normalizer);}
public void serialize(LittleEndianOutput out) {futureHeader.serialize(out);out.writeShort(isf_sharedFeatureType);out.writeByte(reserved1);out.writeInt((int)reserved2);out.writeShort(cellRefs.length);out.writeInt((int)cbFeatData);out.writeShort(reserved3);for(int i=0; i<cellRefs.length; i++) {cellRefs[i].serialize(out);}sharedFeature.serialize(out);}
public GetEmailChannelResult getEmailChannel(GetEmailChannelRequest request) {request = beforeClientExecution(request);return executeGetEmailChannel(request);}
public IncreaseReplicationFactorResult increaseReplicationFactor(IncreaseReplicationFactorRequest request) {request = beforeClientExecution(request);return executeIncreaseReplicationFactor(request);}
public UploadMultipartPartResult uploadMultipartPart(UploadMultipartPartRequest request) {request = beforeClientExecution(request);return executeUploadMultipartPart(request);}
public String toString(){StringBuilder buffer = new StringBuilder();buffer.append( "[LeftMargin]\n" );buffer.append( "    .margin               = " ).append( " (" ).append( getMargin() ).append( " )\n" );buffer.append( "[/LeftMargin]\n" );return buffer.toString();}
public boolean removeLastOccurrence(Object o) {Iterator<E> iter = new ReverseLinkIterator<E>(this);return removeOneOccurrence(o, iter);}
public ExtSSTRecord createExtSSTRecord(int sstOffset) {if (bucketAbsoluteOffsets == null || bucketRelativeOffsets == null) {throw new IllegalStateException("SST record has not yet been serialized.");}ExtSSTRecord extSST = new ExtSSTRecord();extSST.setNumStringsPerBucket((short)8);int[] absoluteOffsets = bucketAbsoluteOffsets.clone();int[] relativeOffsets = bucketRelativeOffsets.clone();for ( int i = 0; i < absoluteOffsets.length; i++ ) {absoluteOffsets[i] += sstOffset;}extSST.setBucketOffsets(absoluteOffsets, relativeOffsets);return extSST;}
public E ceiling(E e) {return backingMap.ceilingKey(e);}
public DescribeScalingActivitiesResult describeScalingActivities() {return describeScalingActivities(new DescribeScalingActivitiesRequest());}
public PurchaseReservedInstancesOfferingRequest(String reservedInstancesOfferingId, Integer instanceCount) {setReservedInstancesOfferingId(reservedInstancesOfferingId);setInstanceCount(instanceCount);}
public BlameCommand blame() {return new BlameCommand(repo);}
public ObjectId idFor(int type, byte[] data, int off, int len) {return delegate().idFor(type, data, off, len);}
public OldStringRecord(RecordInputStream in) {sid = in.getSid();if (in.getSid() == biff2_sid) {field_1_string_len  = (short)in.readUByte();} else {field_1_string_len   = in.readShort();}field_2_bytes = IOUtils.safelyAllocate(field_1_string_len, MAX_RECORD_LENGTH);in.read(field_2_bytes, 0, field_1_string_len);}
public DeleteLexiconResult deleteLexicon(DeleteLexiconRequest request) {request = beforeClientExecution(request);return executeDeleteLexicon(request);}
public TokenStream create(TokenStream input) {return new ArabicNormalizationFilter(input);}
public void decode(byte[] blocks, int blocksOffset, long[] values, int valuesOffset, int iterations) {for (int i = 0; i < iterations; ++i) {final long byte0 = blocks[blocksOffset++] & 0xFF;final long byte1 = blocks[blocksOffset++] & 0xFF;values[valuesOffset++] = (byte0 << 2) | (byte1 >>> 6);final long byte2 = blocks[blocksOffset++] & 0xFF;values[valuesOffset++] = ((byte1 & 63) << 4) | (byte2 >>> 4);final long byte3 = blocks[blocksOffset++] & 0xFF;values[valuesOffset++] = ((byte2 & 15) << 6) | (byte3 >>> 2);final long byte4 = blocks[blocksOffset++] & 0xFF;values[valuesOffset++] = ((byte3 & 3) << 8) | byte4;}}
public ICUTokenizerFactory(Map<String,String> args) {super(args);tailored = new HashMap<>();String rulefilesArg = get(args, RULEFILES);if (rulefilesArg != null) {List<String> scriptAndResourcePaths = splitFileNames(rulefilesArg);for (String scriptAndResourcePath : scriptAndResourcePaths) {int colonPos = scriptAndResourcePath.indexOf(":");String scriptCode = scriptAndResourcePath.substring(0, colonPos).trim();String resourcePath = scriptAndResourcePath.substring(colonPos+1).trim();tailored.put(UCharacter.getPropertyValueEnum(UProperty.SCRIPT, scriptCode), resourcePath);}}cjkAsWords = getBoolean(args, "cjkAsWords", true);myanmarAsWords = getBoolean(args, "myanmarAsWords", true);if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameters: " + args);}}
public final long get(int index) {checkIndex(index);return backingArray[offset + index];}
public void write(int value) throws IOException {checkWritePrimitiveTypes();primitiveTypes.write(value);}
public static boolean isEmptyOrNull(String stringValue) {return stringValue == null || stringValue.length() == 0;}
public ListJournalS3ExportsForLedgerResult listJournalS3ExportsForLedger(ListJournalS3ExportsForLedgerRequest request) {request = beforeClientExecution(request);return executeListJournalS3ExportsForLedger(request);}
public List<FacetEntry> getFacetEntries(int offset, int limit) {List<FacetEntry> entries = new LinkedList<>();int skipped = 0;int included = 0;for (FacetEntry facetEntry : facetEntries) {if (skipped < offset) {skipped++;continue;}if (included++ >= limit) {break;}entries.add(facetEntry);}return entries;}
public List<ParseTreeMatch> findAll(ParseTree tree, String xpath) {Collection<ParseTree> subtrees = XPath.findAll(tree, xpath, matcher.getParser());List<ParseTreeMatch> matches = new ArrayList<ParseTreeMatch>();for (ParseTree t : subtrees) {ParseTreeMatch match = match(t);if ( match.succeeded() ) {matches.add(match);}}return matches;}
public DescribeUsersResult describeUsers(DescribeUsersRequest request) {request = beforeClientExecution(request);return executeDescribeUsers(request);}
public DeleteDirectoryConfigResult deleteDirectoryConfig(DeleteDirectoryConfigRequest request) {request = beforeClientExecution(request);return executeDeleteDirectoryConfig(request);}
public Break(RecordInputStream in) {main = in.readUShort() - 1;subFrom = in.readUShort();subTo = in.readUShort();}
public GetJourneyResult getJourney(GetJourneyRequest request) {request = beforeClientExecution(request);return executeGetJourney(request);}
public LastCellOfRowDummyRecord(int row, int lastColumnNumber) {this.row = row;this.lastColumnNumber = lastColumnNumber;}
public DescribeEventSubscriptionsResult describeEventSubscriptions() {return describeEventSubscriptions(new DescribeEventSubscriptionsRequest());}
public DeleteFacetResult deleteFacet(DeleteFacetRequest request) {request = beforeClientExecution(request);return executeDeleteFacet(request);}
public GetResolverEndpointResult getResolverEndpoint(GetResolverEndpointRequest request) {request = beforeClientExecution(request);return executeGetResolverEndpoint(request);}
public Cluster modifyClusterMaintenance(ModifyClusterMaintenanceRequest request) {request = beforeClientExecution(request);return executeModifyClusterMaintenance(request);}
public UpdateVoiceTemplateResult updateVoiceTemplate(UpdateVoiceTemplateRequest request) {request = beforeClientExecution(request);return executeUpdateVoiceTemplate(request);}
public DescribeEventBusResult describeEventBus(DescribeEventBusRequest request) {request = beforeClientExecution(request);return executeDescribeEventBus(request);}
public void println(boolean b) {println(String.valueOf(b));}
public T removeTop() {T currentTop = top;if (iter.hasNext()) {top = iter.next();} else {top = null;}return currentTop;}
public static List<TransportProtocol> getTransportProtocols() {int cnt = protocols.size();List<TransportProtocol> res = new ArrayList<>(cnt);for (WeakReference<TransportProtocol> ref : protocols) {TransportProtocol proto = ref.get();if (proto != null)res.add(proto);elseprotocols.remove(ref);}return Collections.unmodifiableList(res);}
public String getText(Interval interval) {if (interval.a < 0 || interval.b < interval.a - 1) {throw new IllegalArgumentException("invalid interval");}int bufferStartIndex = getBufferStartIndex();if (n > 0 && data[n - 1] == Character.MAX_VALUE) {if (interval.a + interval.length() > bufferStartIndex + n) {throw new IllegalArgumentException("the interval extends past the end of the stream");}}if (interval.a < bufferStartIndex || interval.b >= bufferStartIndex + n) {throw new UnsupportedOperationException("interval "+interval+" outside buffer: "+bufferStartIndex+".."+(bufferStartIndex+n-1));}int i = interval.a - bufferStartIndex;return new String(data, i, interval.length());}
public CreateAddressResult createAddress(CreateAddressRequest request) {request = beforeClientExecution(request);return executeCreateAddress(request);}
public static DoubleBuffer allocate(int capacity) {if (capacity < 0) {throw new IllegalArgumentException();}return new ReadWriteDoubleArrayBuffer(capacity);}
public static int idealCharArraySize(int need) {return idealByteArraySize(need * 2) / 2;}
public void writeByte(int v) {writeContinueIfRequired(1);_ulrOutput.writeByte(v);}
public ListWorkteamsResult listWorkteams(ListWorkteamsRequest request) {request = beforeClientExecution(request);return executeListWorkteams(request);}
public void println(float f) {println(String.valueOf(f));}
public String asFormulaString() {StringBuilder sb = new StringBuilder(32);asFormulaString(sb);return sb.toString();}
public DescribeApplicationResult describeApplication(DescribeApplicationRequest request) {request = beforeClientExecution(request);return executeDescribeApplication(request);}
public CleanCommand setPaths(Set<String> paths) {this.paths = paths;return this;}
public String toStringTree() {return toStringTree((List<String>)null);}
public static boolean isCellInternalDateFormatted(Cell cell) {if (cell == null) {return false;}boolean bDate = false;double d = cell.getNumericCellValue();if ( DateUtil.isValidExcelDate(d) ) {CellStyle style = cell.getCellStyle();int i = style.getDataFormat();bDate = isInternalDateFormat(i);}return bDate;}
public GetLifecyclePolicyResult getLifecyclePolicy(GetLifecyclePolicyRequest request) {request = beforeClientExecution(request);return executeGetLifecyclePolicy(request);}
public long getFilePointer() {return pointer + pos;}
public Map<String, MergeResult<? extends Sequence>> getMergeResults() {return mergeResults;}
public ListApplicationsResult listApplications() {return listApplications(new ListApplicationsRequest());}
public static RevFilter create(String pattern) {if (pattern.length() == 0)throw new IllegalArgumentException(JGitText.get().cannotMatchOnEmptyString);if (SubStringRevFilter.safe(pattern))return new SubStringSearch(pattern);return new PatternSearch(pattern);}
public void connect(PipedWriter src) throws IOException {src.connect(this);}
public void reset() {if (overflow != null) {destroy();}if (blocks != null)blocks.clear();elseblocks = new ArrayList<>(initialBlocks);blocks.add(new Block(Math.min(inCoreLimit, Block.SZ)));}
public byte readByte() throws IOException {return primitiveTypes.readByte();}
public DeletePublishingDestinationResult deletePublishingDestination(DeletePublishingDestinationRequest request) {request = beforeClientExecution(request);return executeDeletePublishingDestination(request);}
public UpdateSigningCertificateRequest(String certificateId, StatusType status) {setCertificateId(certificateId);setStatus(status.toString());}
@Override public boolean isEmpty() {return endpoint(true) == null;}
public DescribeSpotInstanceRequestsResult describeSpotInstanceRequests() {return describeSpotInstanceRequests(new DescribeSpotInstanceRequestsRequest());}
public GetLifecyclePoliciesResult getLifecyclePolicies(GetLifecyclePoliciesRequest request) {request = beforeClientExecution(request);return executeGetLifecyclePolicies(request);}
public DeleteVpcPeeringConnectionResult deleteVpcPeeringConnection(DeleteVpcPeeringConnectionRequest request) {request = beforeClientExecution(request);return executeDeleteVpcPeeringConnection(request);}
public final void removeFields(String name) {Iterator<IndexableField> it = fields.iterator();while (it.hasNext()) {IndexableField field = it.next();if (field.name().equals(name)) {it.remove();}}}
public ParseException generateParseException() {jj_expentries.clear();boolean[] la1tokens = new boolean[33];if (jj_kind >= 0) {la1tokens[jj_kind] = true;jj_kind = -1;}for (int i = 0; i < 25; i++) {if (jj_la1[i] == jj_gen) {for (int j = 0; j < 32; j++) {if ((jj_la1_0[i] & (1<<j)) != 0) {la1tokens[j] = true;}if ((jj_la1_1[i] & (1<<j)) != 0) {la1tokens[32+j] = true;}}}}for (int i = 0; i < 33; i++) {if (la1tokens[i]) {jj_expentry = new int[1];jj_expentry[0] = i;jj_expentries.add(jj_expentry);}}jj_endpos = 0;jj_rescan_token();jj_add_error_token(0, 0);int[][] exptokseq = new int[jj_expentries.size()][];for (int i = 0; i < jj_expentries.size(); i++) {exptokseq[i] = jj_expentries.get(i);}return new ParseException(token, exptokseq, tokenImage);}
public void execute(Lexer lexer) {lexer.mode(mode);}
public int peekNextSid() {if(!hasNext()) {return -1;}return _list.get(_nextIndex).getSid();}
public EnableOrganizationAdminAccountResult enableOrganizationAdminAccount(EnableOrganizationAdminAccountRequest request) {request = beforeClientExecution(request);return executeEnableOrganizationAdminAccount(request);}
public ValueEval evaluate(int srcRowIndex, int srcColumnIndex, ValueEval arg0, ValueEval arg1,ValueEval arg2, ValueEval arg3) {return evaluate(srcRowIndex, srcColumnIndex, arg0, arg1, arg2, arg3, DEFAULT_ARG4);}
public NameRecord getSpecificBuiltinRecord(byte name, int sheetNumber){return getOrCreateLinkTable().getSpecificBuiltinRecord(name, sheetNumber);}
public CellReference[] getAllReferencedCells() {if(_isSingleCell) {return  new CellReference[] { _firstCell, };}int minRow = Math.min(_firstCell.getRow(), _lastCell.getRow());int maxRow = Math.max(_firstCell.getRow(), _lastCell.getRow());int minCol = Math.min(_firstCell.getCol(), _lastCell.getCol());int maxCol = Math.max(_firstCell.getCol(), _lastCell.getCol());String sheetName = _firstCell.getSheetName();List<CellReference> refs = new ArrayList<>();for(int row=minRow; row<=maxRow; row++) {for(int col=minCol; col<=maxCol; col++) {CellReference ref = new CellReference(sheetName, row, col, _firstCell.isRowAbsolute(), _firstCell.isColAbsolute());refs.add(ref);}}return refs.toArray(new CellReference[0]);}
public void readFully(byte[] buffer, int off, int len) {checkPosition(len);read(buffer, off, len);}
public ImportTerminologyResult importTerminology(ImportTerminologyRequest request) {request = beforeClientExecution(request);return executeImportTerminology(request);}
public EscherSimpleProperty( short id, int propertyValue ) {super( id );this.propertyValue = propertyValue;}
public String toString() {StringBuilder buffer = new StringBuilder();buffer.append("[STARTBLOCK]\n");buffer.append("    .rt              =").append(HexDump.shortToHex(rt)).append('\n');buffer.append("    .grbitFrt        =").append(HexDump.shortToHex(grbitFrt)).append('\n');buffer.append("    .iObjectKind     =").append(HexDump.shortToHex(iObjectKind)).append('\n');buffer.append("    .iObjectContext  =").append(HexDump.shortToHex(iObjectContext)).append('\n');buffer.append("    .iObjectInstance1=").append(HexDump.shortToHex(iObjectInstance1)).append('\n');buffer.append("    .iObjectInstance2=").append(HexDump.shortToHex(iObjectInstance2)).append('\n');buffer.append("[/STARTBLOCK]\n");return buffer.toString();}
public ATNDeserializer(ATNDeserializationOptions deserializationOptions) {if (deserializationOptions == null) {deserializationOptions = ATNDeserializationOptions.getDefaultOptions();}this.deserializationOptions = deserializationOptions;}
public ListPartnerEventSourcesResult listPartnerEventSources(ListPartnerEventSourcesRequest request) {request = beforeClientExecution(request);return executeListPartnerEventSources(request);}
public boolean equals(Object obj) {if (this == obj)return true;if (!super.equals(obj))return false;if (getClass() != obj.getClass())return false;TermRangeQuery other = (TermRangeQuery) obj;if (includeLower != other.includeLower)return false;if (includeUpper != other.includeUpper)return false;if (lowerTerm == null) {if (other.lowerTerm != null)return false;} else if (!lowerTerm.equals(other.lowerTerm))return false;if (upperTerm == null) {if (other.upperTerm != null)return false;} else if (!upperTerm.equals(other.upperTerm))return false;return true;}
public GetRequestValidatorResult getRequestValidator(GetRequestValidatorRequest request) {request = beforeClientExecution(request);return executeGetRequestValidator(request);}
public UpdateRoomResult updateRoom(UpdateRoomRequest request) {request = beforeClientExecution(request);return executeUpdateRoom(request);}
public DescribeConfigurationResult describeConfiguration(DescribeConfigurationRequest request) {request = beforeClientExecution(request);return executeDescribeConfiguration(request);}
public void writeShort(int v) {int b1 = (v >>>  8) & 0xFF;int b0 = (v) & 0xFF;try {out.write(b0);out.write(b1);} catch (IOException e) {throw new RuntimeException(e);}}
public ValueEval evaluate(ValueEval[] args, OperationEvaluationContext ec) {if (args.length == 1) {return evaluate(ec.getRowIndex(), ec.getColumnIndex(), args[0]);}if (args.length == 2) {return evaluate(ec.getRowIndex(), ec.getColumnIndex(), args[0], args[1]);}return ErrorEval.VALUE_INVALID;}
public ListTemplateVersionsResult listTemplateVersions(ListTemplateVersionsRequest request) {request = beforeClientExecution(request);return executeListTemplateVersions(request);}
public CanonicalTreeParser() {reset(EMPTY);}
public ListBootstrapActionsResult listBootstrapActions(ListBootstrapActionsRequest request) {request = beforeClientExecution(request);return executeListBootstrapActions(request);}
public DeleteTransitGatewayVpcAttachmentResult deleteTransitGatewayVpcAttachment(DeleteTransitGatewayVpcAttachmentRequest request) {request = beforeClientExecution(request);return executeDeleteTransitGatewayVpcAttachment(request);}
public DescribeLoadBalancerPoliciesResult describeLoadBalancerPolicies(DescribeLoadBalancerPoliciesRequest request) {request = beforeClientExecution(request);return executeDescribeLoadBalancerPolicies(request);}
public CheckDomainAvailabilityResult checkDomainAvailability(CheckDomainAvailabilityRequest request) {request = beforeClientExecution(request);return executeCheckDomainAvailability(request);}
public String toString() {return "INDEX_DIFF_FILTER"; }
public ListJourneysResult listJourneys(ListJourneysRequest request) {request = beforeClientExecution(request);return executeListJourneys(request);}
public long getEntryLastModified() {return current().getLastModified();}
public int addConditionalFormatting(CellRangeAddress[] regions,HSSFConditionalFormattingRule rule1,HSSFConditionalFormattingRule rule2) {return addConditionalFormatting(regions,new HSSFConditionalFormattingRule[] { rule1, rule2 });}
public long getCreationTime() {return decodeTS(P_CTIME);}
public DescribeBrokerEngineTypesResult describeBrokerEngineTypes(DescribeBrokerEngineTypesRequest request) {request = beforeClientExecution(request);return executeDescribeBrokerEngineTypes(request);}
public void println(Object obj) {println(String.valueOf(obj));}
public String toString(){StringBuilder buffer = new StringBuilder();buffer.append("[ftEnd]\n");buffer.append("[/ftEnd]\n");return buffer.toString();}
public String toString() {return getClass().getSimpleName() + "(compressionMode=" + compressionMode+ ", chunkSize=" + chunkSize + ", maxDocsPerChunk=" + maxDocsPerChunk + ", blockShift=" + blockShift + ")";}
public GetConsoleOutputResult getConsoleOutput(GetConsoleOutputRequest request) {request = beforeClientExecution(request);return executeGetConsoleOutput(request);}
public static List<ParseTree> findAllNodes(ParseTree t, int index, boolean findTokens) {List<ParseTree> nodes = new ArrayList<ParseTree>();_findAllNodes(t, index, findTokens, nodes);return nodes;}
public RevObject next() {return objItr.hasNext() ? objItr.next() : null;}
public DescribeDirectConnectGatewayAssociationProposalsResult describeDirectConnectGatewayAssociationProposals(DescribeDirectConnectGatewayAssociationProposalsRequest request) {request = beforeClientExecution(request);return executeDescribeDirectConnectGatewayAssociationProposals(request);}
public String getFragment() {return decode(fragment);}
public boolean equals(Object o) {if (this == o) {return true;}if (o == null || getClass() != o.getClass()) {return false;}Arn arn = (Arn) o;if (!partition.equals(arn.partition)) {return false;}if (!service.equals(arn.service)) {return false;}if (region != null ? !region.equals(arn.region) : arn.region != null) {return false;}if (accountId != null ? !accountId.equals(arn.accountId) : arn.accountId != null) {return false;}return resource.equals(arn.resource);}
public ValueEval getRelativeValue(int sheetIndex, int relativeRowIndex, int relativeColumnIndex) {int rowIx = (relativeRowIndex + getFirstRow() ) ;int colIx = (relativeColumnIndex + getFirstColumn() ) ;return _evaluator.getEvalForCell(sheetIndex, rowIx, colIx);}
public DescribeMonitoringScheduleResult describeMonitoringSchedule(DescribeMonitoringScheduleRequest request) {request = beforeClientExecution(request);return executeDescribeMonitoringSchedule(request);}
public NumericPayloadTokenFilter create(TokenStream input) {return new NumericPayloadTokenFilter(input,payload,typeMatch);}
public ModifyDBParameterGroupResult modifyDBParameterGroup(ModifyDBParameterGroupRequest request) {request = beforeClientExecution(request);return executeModifyDBParameterGroup(request);}
public Reader create(Reader input) {return new PatternReplaceCharFilter(pattern, replacement, input);}
public DataLabelExtensionRecord(RecordInputStream in) {rt = in.readShort();grbitFrt = in.readShort();in.readFully(unused);}
public ListOnPremisesInstancesResult listOnPremisesInstances(ListOnPremisesInstancesRequest request) {request = beforeClientExecution(request);return executeListOnPremisesInstances(request);}
public DeleteVaultRequest(String accountId, String vaultName) {setAccountId(accountId);setVaultName(vaultName);}
public FederatedUser(String federatedUserId, String arn) {setFederatedUserId(federatedUserId);setArn(arn);}
public String toString() {String inv = invert ? "!" : "";return getClass().getSimpleName()+"["+inv+nodeName+"]";}
public float hyperbolicTf(float freq) {if (0.0f == freq) return 0.0f;final float min = tf_hyper_min;final float max = tf_hyper_max;final double base = tf_hyper_base;final float xoffset = tf_hyper_xoffset;final double x = (double)(freq - xoffset);final float result = min +(float)((max-min) / 2.0f*(( ( Math.pow(base,x) - Math.pow(base,-x) )/ ( Math.pow(base,x) + Math.pow(base,-x) ))+ 1.0d));return Float.isNaN(result) ? max : result;}
public HSSFCell getCell(int cellnum, MissingCellPolicy policy) {HSSFCell cell = retrieveCell(cellnum);switch (policy) {case RETURN_NULL_AND_BLANK:return cell;case RETURN_BLANK_AS_NULL:boolean isBlank = (cell != null && cell.getCellType() == CellType.BLANK);return (isBlank) ? null : cell;case CREATE_NULL_AS_BLANK:return (cell == null) ? createCell(cellnum, CellType.BLANK) : cell;default:throw new IllegalArgumentException("Illegal policy " + policy);}}
public DeleteRoomMembershipResult deleteRoomMembership(DeleteRoomMembershipRequest request) {request = beforeClientExecution(request);return executeDeleteRoomMembership(request);}
public AcsRequest buildRequest() {if (uriPattern != null) {CommonRoaRequest request = new CommonRoaRequest(product);request.setSysUriPattern(uriPattern);for (String pathParamKey : pathParameters.keySet()) {request.putPathParameter(pathParamKey, pathParameters.get(pathParamKey));}fillParams(request);return request;} else {CommonRpcRequest request = new CommonRpcRequest(product);fillParams(request);return request;}}
public ListDevelopmentSchemaArnsResult listDevelopmentSchemaArns(ListDevelopmentSchemaArnsRequest request) {request = beforeClientExecution(request);return executeListDevelopmentSchemaArns(request);}
public Ptg[] getResult() {return _ptgs;}
public EscherPropertyMetaData( String description ){this.description = description;}
public DeleteNetworkProfileResult deleteNetworkProfile(DeleteNetworkProfileRequest request) {request = beforeClientExecution(request);return executeDeleteNetworkProfile(request);}
public String toString() {StringBuilder buffer = new StringBuilder();buffer.append("[FOOTER]\n");buffer.append("    .footer = ").append(getText()).append("\n");buffer.append("[/FOOTER]\n");return buffer.toString();}
public ListMultipartUploadsRequest(String vaultName) {setVaultName(vaultName);}
public final boolean isRegistered() {return !canonicalName.startsWith("x-") && !canonicalName.startsWith("X-");}
public RemoveTagsRequest(String resourceId, java.util.List<String> tagKeys) {setResourceId(resourceId);setTagKeys(tagKeys);}
public DescribeSecurityConfigurationResult describeSecurityConfiguration(DescribeSecurityConfigurationRequest request) {request = beforeClientExecution(request);return executeDescribeSecurityConfiguration(request);}
public boolean isRemote() {return getHost() != null;}
public String getPassphrase() {return passphrase;}
public final AttributeFactory getAttributeFactory() {return this.factory;}
public PutGroupPolicyRequest(String groupName, String policyName, String policyDocument) {setGroupName(groupName);setPolicyName(policyName);setPolicyDocument(policyDocument);}
public BufferedOutputStream(OutputStream out, int size) {super(out);if (size <= 0) {throw new IllegalArgumentException("size <= 0");}buf = new byte[size];}
public void add(UDFFinder toolPack){_usedToolPacks.add(toolPack);}
public AlibabaCloudCredentials getCredentials() throws ClientException {if (credentials == null || credentials.isExpired()) {ecsMetadataServiceFetchCount += 1;int maxRetryTimes = MAX_ECS_METADATA_FETCH_RETRY_TIMES;credentials = fetcher.fetch(maxRetryTimes);} else if (credentials.willSoonExpire() && credentials.shouldRefresh()) {try {ecsMetadataServiceFetchCount += 1;credentials = fetcher.fetch();} catch (ClientException e) {credentials.setLastFailedRefreshTime();}}return credentials;}
public int serialize(int offset, byte[] data, EscherSerializationListener listener) {listener.beforeRecordSerialize( offset, getRecordId(), this );LittleEndian.putShort(data, offset, getOptions());LittleEndian.putShort(data, offset+2, getRecordId());int remainingBytes = thedata.length;for (EscherRecord r : _childRecords) {remainingBytes += r.getRecordSize();}LittleEndian.putInt(data, offset+4, remainingBytes);System.arraycopy(thedata, 0, data, offset+8, thedata.length);int pos = offset+8+thedata.length;for (EscherRecord r : _childRecords) {pos += r.serialize(pos, data, listener );}listener.afterRecordSerialize( pos, getRecordId(), pos - offset, this );return pos - offset;}
public int getFunctionIndex(String name) {return name.hashCode();}
public PredicateTransition(ATNState target, int ruleIndex, int predIndex, boolean isCtxDependent) {super(target);this.ruleIndex = ruleIndex;this.predIndex = predIndex;this.isCtxDependent = isCtxDependent;}
public FileMode getOldMode() {return getOldMode(0);}
public static RevFilter create(int skip) {if (skip < 0)throw new IllegalArgumentException(JGitText.get().skipMustBeNonNegative);return new SkipRevFilter(skip);}
public BlameCommand setStartCommit(AnyObjectId commit) {this.startCommit = commit.toObjectId();return this;}
public static int intersect(CellRangeAddress crA, CellRangeAddress crB ){int firstRow = crB.getFirstRow();int lastRow  = crB.getLastRow();int firstCol = crB.getFirstColumn();int lastCol  = crB.getLastColumn();if (gt(crA.getFirstRow(),    lastRow) || lt(crA.getLastRow(),    firstRow) ||gt(crA.getFirstColumn(), lastCol) || lt(crA.getLastColumn(), firstCol)){return NO_INTERSECTION;}else if( contains(crA, crB) ){return INSIDE;}else if( contains(crB, crA)){return ENCLOSES;}else{return OVERLAP;}}
public HSSFRequest() {_records = new HashMap<>(50); }
public GetKeyPairResult getKeyPair(GetKeyPairRequest request) {request = beforeClientExecution(request);return executeGetKeyPair(request);}
public RunTaskResult runTask(RunTaskRequest request) {request = beforeClientExecution(request);return executeRunTask(request);}
public RemoveAlbumPhotosRequest() {super("CloudPhoto", "2017-07-11", "RemoveAlbumPhotos", "cloudphoto");setProtocol(ProtocolType.HTTPS);}
public CharBuffer asReadOnlyBuffer() {return duplicate();}
public CreateDatasetGroupResult createDatasetGroup(CreateDatasetGroupRequest request) {request = beforeClientExecution(request);return executeCreateDatasetGroup(request);}
public final int position() {return position;}
public GetRelationalDatabaseMasterUserPasswordResult getRelationalDatabaseMasterUserPassword(GetRelationalDatabaseMasterUserPasswordRequest request) {request = beforeClientExecution(request);return executeGetRelationalDatabaseMasterUserPassword(request);}
public GetDownloadUrlsRequest() {super("CloudPhoto", "2017-07-11", "GetDownloadUrls", "cloudphoto");setProtocol(ProtocolType.HTTPS);}
public void writeLong(long v) {writeInt((int)(v));writeInt((int)(v >> 32));}
public DescribeLocalGatewaysResult describeLocalGateways(DescribeLocalGatewaysRequest request) {request = beforeClientExecution(request);return executeDescribeLocalGateways(request);}
public ConstValueSource(float constant) {this.constant = constant;this.dv = constant;}
public DeleteExperimentResult deleteExperiment(DeleteExperimentRequest request) {request = beforeClientExecution(request);return executeDeleteExperiment(request);}
public ShowNoteCommand notesShow() {return new ShowNoteCommand(repo);}
@Override public boolean isEmpty() {Slice slice = this.slice;return slice.from == slice.to;}
public void addFieldConfigListener(FieldConfigListener listener) {this.listeners.add(listener);}
public CreateApplicationRequest(String applicationName) {setApplicationName(applicationName);}
public void reset(byte[] bytes, int offset, int len) {this.bytes = bytes;pos = offset;limit = offset + len;}
public DescribeVpcAttributeResult describeVpcAttribute(DescribeVpcAttributeRequest request) {request = beforeClientExecution(request);return executeDescribeVpcAttribute(request);}
public void setNewPrefix(String prefix) {newPrefix = prefix;}
public DescribeSpotPriceHistoryResult describeSpotPriceHistory(DescribeSpotPriceHistoryRequest request) {request = beforeClientExecution(request);return executeDescribeSpotPriceHistory(request);}
public String toFormulaString() {StringBuilder sb = new StringBuilder(64);if (externalWorkbookNumber >= 0) {sb.append('[');sb.append(externalWorkbookNumber);sb.append(']');}if (sheetName != null) {SheetNameFormatter.appendFormat(sb, sheetName);}sb.append('!');sb.append(FormulaError.REF.getString());return sb.toString();}
public final String getShortMessage() {byte[] raw = buffer;int msgB = RawParseUtils.commitMessage(raw, 0);if (msgB < 0) {return ""; }int msgE = RawParseUtils.endOfParagraph(raw, msgB);String str = RawParseUtils.decode(guessEncoding(), raw, msgB, msgE);if (hasLF(raw, msgB, msgE)) {str = StringUtils.replaceLineBreaksWithSpace(str);}return str;}
public PutEventsConfigurationResult putEventsConfiguration(PutEventsConfigurationRequest request) {request = beforeClientExecution(request);return executePutEventsConfiguration(request);}
public ApproveSkillResult approveSkill(ApproveSkillRequest request) {request = beforeClientExecution(request);return executeApproveSkill(request);}
public TokenFilter create(TokenStream input) {return new KStemFilter(input);}
public double get() {if (position == limit) {throw new BufferUnderflowException();}return byteBuffer.getDouble(position++ * SizeOf.DOUBLE);}
public Content(String data) {setData(data);}
public CleanCommand setDryRun(boolean dryRun) {this.dryRun = dryRun;return this;}
public GetOnPremisesInstanceResult getOnPremisesInstance(GetOnPremisesInstanceRequest request) {request = beforeClientExecution(request);return executeGetOnPremisesInstance(request);}
public MutableEntry cloneEntry() {final MutableEntry r = new MutableEntry();ensureId();r.idBuffer.fromObjectId(idBuffer);r.offset = offset;return r;}
public QueryParser(QueryParserTokenManager tm) {token_source = tm;token = new Token();jj_ntk = -1;jj_gen = 0;for (int i = 0; i < 10; i++) jj_la1[i] = -1;for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();}
public URISyntaxException(String input, String reason, int index) {super(reason);if (input == null || reason == null) {throw new NullPointerException();}if (index < -1) {throw new IllegalArgumentException();}this.input = input;this.index = index;}
public boolean equals(Object obj) {if (obj == null)return false;if (obj == this)return true;if (obj.getClass() != getClass())return false;HSSFChildAnchor anchor = (HSSFChildAnchor) obj;return anchor.getDx1() == getDx1() && anchor.getDx2() == getDx2() && anchor.getDy1() == getDy1()&& anchor.getDy2() == getDy2();}
@Override public E set(int location, E object) {synchronized (mutex) {return list.set(location, object);}}
public DescribeReservedDBInstancesOfferingsResult describeReservedDBInstancesOfferings() {return describeReservedDBInstancesOfferings(new DescribeReservedDBInstancesOfferingsRequest());}
public Snapshot revokeSnapshotAccess(RevokeSnapshotAccessRequest request) {request = beforeClientExecution(request);return executeRevokeSnapshotAccess(request);}
public int setArrayData(byte[] data, int offset) {if (emptyComplexPart) {resizeComplexData(0);} else {short numElements = LittleEndian.getShort(data, offset);short sizeOfElements = LittleEndian.getShort(data, offset + 4);int cdLen = getComplexData().length;int arraySize = getActualSizeOfElements(sizeOfElements) * numElements;if (arraySize == cdLen) {resizeComplexData(arraySize + 6, 0);sizeIncludesHeaderSize = false;}setComplexData(data, offset);}return getComplexData().length;}
public void serialize(LittleEndianOutput out) {out.writeShort(_numberOfRegions);for (int i = 0; i < _numberOfRegions; i++) {_regions[_startIndex + i].serialize(out);}}
public TokenStream create(TokenStream input) {return new JapaneseKatakanaStemFilter(input, minimumLength);}
public ListFindingsResult listFindings(ListFindingsRequest request) {request = beforeClientExecution(request);return executeListFindings(request);}
public DBInstance createDBInstance(CreateDBInstanceRequest request) {request = beforeClientExecution(request);return executeCreateDBInstance(request);}
public Repository open(C req, String name)throws RepositoryNotFoundException, ServiceNotEnabledException {if (isUnreasonableName(name))throw new RepositoryNotFoundException(name);Repository db = exports.get(nameWithDotGit(name));if (db != null) {db.incrementOpen();return db;}for (File base : exportBase) {File dir = FileKey.resolve(new File(base, name), FS.DETECTED);if (dir == null)continue;try {FileKey key = FileKey.exact(dir, FS.DETECTED);db = RepositoryCache.open(key, true);} catch (IOException e) {throw new RepositoryNotFoundException(name, e);}try {if (isExportOk(req, name, db)) {return db;}throw new ServiceNotEnabledException();} catch (RuntimeException | IOException e) {db.close();throw new RepositoryNotFoundException(name, e);} catch (ServiceNotEnabledException e) {db.close();throw e;}}if (exportBase.size() == 1) {File dir = new File(exportBase.iterator().next(), name);throw new RepositoryNotFoundException(name,new RepositoryNotFoundException(dir));}throw new RepositoryNotFoundException(name);}
public GetAuthorizerResult getAuthorizer(GetAuthorizerRequest request) {request = beforeClientExecution(request);return executeGetAuthorizer(request);}
public void finish(FieldInfos fis, int numDocs) throws IOException {if (numDocsWritten != numDocs) {throw new RuntimeException("mergeFields produced an invalid result: docCount is " + numDocs+ " but only saw " + numDocsWritten + " file=" + out.toString() + "; now aborting this merge to prevent index corruption");}write(END);newLine();SimpleTextUtil.writeChecksum(out, scratch);}
public boolean isFormulaSame(SharedFormulaRecord other) {return field_7_parsed_expr.isSame(other.field_7_parsed_expr);}
@Override public Object[] toArray() {return snapshot().toArray();}
public ValueEval getRefEval(int rowIndex, int columnIndex) {SheetRangeEvaluator sre = getRefEvaluatorForCurrentSheet();return new LazyRefEval(rowIndex, columnIndex, sre);}
public int hash2(char carray[]) {int hash = 5381;for (int i = 0; i < carray.length; i++) {char d = carray[i];hash = ((hash << 5) + hash) + d & 0x00FF;hash = ((hash << 5) + hash) + d >> 8;}return hash;}
public UpdateRepoSourceRepoRequest() {super("cr", "2016-06-07", "UpdateRepoSourceRepo", "cr");setUriPattern("/repos/[RepoNamespace]/[RepoName]/sourceRepo");setMethod(MethodType.POST);}
public static DVConstraint createCustomFormulaConstraint(String formula) {if (formula == null) {throw new IllegalArgumentException("formula must be supplied");}return new DVConstraint(ValidationType.FORMULA, OperatorType.IGNORED, formula, null, null, null, null);}
public static String toHex(byte value) {StringBuilder sb = new StringBuilder(2);writeHex(sb, value & 0xFF, 2, "");return sb.toString();}
public CreateNamespaceAuthorizationRequest() {super("cr", "2016-06-07", "CreateNamespaceAuthorization", "cr");setUriPattern("/namespace/[Namespace]/authorizations");setMethod(MethodType.PUT);}
public GetAccountSettingsResult getAccountSettings(GetAccountSettingsRequest request) {request = beforeClientExecution(request);return executeGetAccountSettings(request);}
public CreateVoiceTemplateResult createVoiceTemplate(CreateVoiceTemplateRequest request) {request = beforeClientExecution(request);return executeCreateVoiceTemplate(request);}
public ListHITsForQualificationTypeResult listHITsForQualificationType(ListHITsForQualificationTypeRequest request) {request = beforeClientExecution(request);return executeListHITsForQualificationType(request);}
public DeltaIndex(byte[] sourceBuffer) {src = sourceBuffer;DeltaIndexScanner scan = new DeltaIndexScanner(src, src.length);table = scan.table;tableMask = scan.tableMask;entries = new long[1 + countEntries(scan)];copyEntries(scan);}
public final ObjectId copy() {if (getClass() == ObjectId.class)return (ObjectId) this;return new ObjectId(this);}
public InclusiveRange(long start, long end) {assert end >= start;this.start = start;this.end = end;}
public UnlinkDeveloperIdentityResult unlinkDeveloperIdentity(UnlinkDeveloperIdentityRequest request) {request = beforeClientExecution(request);return executeUnlinkDeveloperIdentity(request);}
public boolean equals(Object other) {if (other == null) {return false;}if (other instanceof CharsRef) {return this.charsEquals((CharsRef) other);}return false;}
public void close() {synchronized (lock) {if (isOpen()) {buf = null;}}}
public ByteArrayDataInput(byte[] bytes, int offset, int len) {reset(bytes, offset, len);}
public final boolean hasNext() {return next != header;}
public void close() throws IOException {Throwable thrown = null;try {flush();} catch (Throwable e) {thrown = e;}try {out.close();} catch (Throwable e) {if (thrown == null) {thrown = e;}}if (thrown != null) {SneakyThrow.sneakyThrow(thrown);}}
public String toString() { return toString(false); }
public DescribeAutoScalingNotificationTypesResult describeAutoScalingNotificationTypes() {return describeAutoScalingNotificationTypes(new DescribeAutoScalingNotificationTypesRequest());}
public BooleanQueryBuilder(QueryBuilder factory) {this.factory = factory;}
public InfoSubRecord(int streamPos, int bucketSstOffset) {field_1_stream_pos        = streamPos;field_2_bucket_sst_offset = bucketSstOffset;}
public void write(LittleEndianOutput out) {out.writeByte(sid + getPtgClass());out.writeByte(getNumberOfOperands());out.writeShort(getFunctionIndex());}
public DeleteVolumeResult deleteVolume(DeleteVolumeRequest request) {request = beforeClientExecution(request);return executeDeleteVolume(request);}
public ListDomainDeliverabilityCampaignsResult listDomainDeliverabilityCampaigns(ListDomainDeliverabilityCampaignsRequest request) {request = beforeClientExecution(request);return executeListDomainDeliverabilityCampaigns(request);}
public void notifyListeners(LexerNoViableAltException e) {String text = _input.getText(Interval.of(_tokenStartCharIndex, _input.index()));String msg = "token recognition error at: '"+ getErrorDisplay(text) + "'";ANTLRErrorListener listener = getErrorListenerDispatch();listener.syntaxError(this, null, _tokenStartLine, _tokenStartCharPositionInLine, msg, e);}
public void fillPolygon(int[] xPoints, int[] yPoints,int nPoints){int right  = findBiggest(xPoints);int bottom = findBiggest(yPoints);int left   = findSmallest(xPoints);int top    = findSmallest(yPoints);HSSFPolygon shape = escherGroup.createPolygon(new HSSFChildAnchor(left,top,right,bottom) );shape.setPolygonDrawArea(right - left, bottom - top);shape.setPoints(addToAll(xPoints, -left), addToAll(yPoints, -top));shape.setLineStyleColor(foreground.getRed(), foreground.getGreen(), foreground.getBlue());shape.setFillColor(foreground.getRed(), foreground.getGreen(), foreground.getBlue());}
public boolean equals(Object obj) {if (!(obj instanceof RowColKey)) {return false;}RowColKey other = (RowColKey) obj;return _rowIndex == other._rowIndex && _columnIndex == other._columnIndex;}
public UpdateDetectorVersionStatusResult updateDetectorVersionStatus(UpdateDetectorVersionStatusRequest request) {request = beforeClientExecution(request);return executeUpdateDetectorVersionStatus(request);}
public void reset(int point) {this.point = point;ends.next = 0;starts.next = 0;}
public void drawPolyline(int[] xPoints, int[] yPoints,int nPoints){if (logger.check( POILogger.WARN ))logger.log(POILogger.WARN,"drawPolyline not supported");}
public String getSignerVersion() {return null;}
public UpdateResolverRuleResult updateResolverRule(UpdateResolverRuleRequest request) {request = beforeClientExecution(request);return executeUpdateResolverRule(request);}
public GetApnsVoipChannelResult getApnsVoipChannel(GetApnsVoipChannelRequest request) {request = beforeClientExecution(request);return executeGetApnsVoipChannel(request);}
public int getSourceStart() {return outRegion.sourceStart;}
public String toString() {return "SkipWorkTree(" + treeIdx + ")";}
public Resource(String resource) {this.resource = resource;}
public MergeCellsRecord(CellRangeAddress[] regions, int startIndex, int numberOfRegions) {_regions = regions;_startIndex = startIndex;_numberOfRegions = numberOfRegions;}
public Set<Entry<K, V>> entrySet() {Set<Entry<K, V>> es = entrySet;return (es != null) ? es : (entrySet = new EntrySet());}
public List<Ref> getRevertedRefs() {return revertedRefs;}
public SendEmailRequest(String source, Destination destination, Message message) {setSource(source);setDestination(destination);setMessage(message);}
public PushCommand setProgressMonitor(ProgressMonitor monitor) {checkCallable();if (monitor == null) {monitor = NullProgressMonitor.INSTANCE;}this.monitor = monitor;return this;}
public static byte[] copyOf(byte[] original, int newLength) {if (newLength < 0) {throw new NegativeArraySizeException();}return copyOfRange(original, 0, newLength);}
public FeatHdrRecord clone() {return copy();}
public GetSubUserListRequest() {super("cr", "2016-06-07", "GetSubUserList", "cr");setUriPattern("/users/subAccount");setMethod(MethodType.GET);}
public boolean add(char[] text) {return map.put(text, PLACEHOLDER) == null;}
public ReadTask(PerfRunData runData) {super(runData);if (withSearch()) {queryMaker = getQueryMaker();} else {queryMaker = null;}}
public StoredField(String name, double value) {super(name, TYPE);fieldsData = value;}
public GetDownloadUrlRequest() {super("CloudPhoto", "2017-07-11", "GetDownloadUrl", "cloudphoto");setProtocol(ProtocolType.HTTPS);}
public RunJobFlowResult runJobFlow(RunJobFlowRequest request) {request = beforeClientExecution(request);return executeRunJobFlow(request);}
public final ValueEval getValue(int sheetIndex, int row, int col) {return getRelativeValue(sheetIndex, row, col);}
public String toString() {return "[PRECISION]\n" +"    .precision       = " + getFullPrecision() +"\n" +"[/PRECISION]\n";}
@Override public int read() throws IOException {return Streams.readSingleByte(this);}
public DiffCommand diff() {return new DiffCommand(repo);}
public static Ptg[] getTokens(Formula formula) {if (formula == null) {return null;}return formula.getTokens();}
public Map.Entry<K, V> next() {if (!valueIterator.hasNext()) {findValueIteratorAndKey();}return Maps.immutableEntry(key, valueIterator.next());}
public int getFormat() {return PACK_DELTA;}
public RemoveAutoScalingPolicyResult removeAutoScalingPolicy(RemoveAutoScalingPolicyRequest request) {request = beforeClientExecution(request);return executeRemoveAutoScalingPolicy(request);}
public DeleteHealthCheckResult deleteHealthCheck(DeleteHealthCheckRequest request) {request = beforeClientExecution(request);return executeDeleteHealthCheck(request);}
public ListS3ResourcesResult listS3Resources(ListS3ResourcesRequest request) {request = beforeClientExecution(request);return executeListS3Resources(request);}
public String toString() {return "MERGE_BASE"; }
public final byte[] array() {return protectedArray();}
public TokenStream create(TokenStream input) {final TokenStream filter = new TypeTokenFilter(input, stopTypes, useWhitelist);return filter;}
public PutPermissionResult putPermission(PutPermissionRequest request) {request = beforeClientExecution(request);return executePutPermission(request);}
public DeleteBaiduChannelResult deleteBaiduChannel(DeleteBaiduChannelRequest request) {request = beforeClientExecution(request);return executeDeleteBaiduChannel(request);}
public CharSequence toQueryString(EscapeQuerySyntax escaper) {return "[DELETEDCHILD]";}
public void write(String str, int offset, int count) throws IOException {synchronized (lock) {if (count < 0) {throw new StringIndexOutOfBoundsException(str, offset, count);}if (str == null) {throw new NullPointerException("str == null");}if ((offset | count) < 0 || offset > str.length() - count) {throw new StringIndexOutOfBoundsException(str, offset, count);}checkStatus();CharBuffer chars = CharBuffer.wrap(str, offset, count + offset);convert(chars);}}
public LogCommand setMaxCount(int maxCount) {checkCallable();this.maxCount = maxCount;return this;}
public IntBuffer duplicate() {return copy(this, mark);}
public Header(InputStream is) throws IOException {final MimeStreamParser parser = new MimeStreamParser();parser.setContentHandler(new AbstractContentHandler() {@Override
public CreateInstanceExportTaskResult createInstanceExportTask(CreateInstanceExportTaskRequest request) {request = beforeClientExecution(request);return executeCreateInstanceExportTask(request);}
public void writeChars(String value) throws IOException {checkWritePrimitiveTypes();primitiveTypes.writeChars(value);}
public DisassociateMemberFromGroupResult disassociateMemberFromGroup(DisassociateMemberFromGroupRequest request) {request = beforeClientExecution(request);return executeDisassociateMemberFromGroup(request);}
public UnmonitorInstancesRequest(java.util.List<String> instanceIds) {setInstanceIds(instanceIds);}
public ListProfileTimesResult listProfileTimes(ListProfileTimesRequest request) {request = beforeClientExecution(request);return executeListProfileTimes(request);}
public boolean add(char[] text) {return map.put(text, PLACEHOLDER) == null;}
public long ramBytesUsed() {return fst == null ? 0 : fst.ramBytesUsed();}
public GetCampaignVersionsResult getCampaignVersions(GetCampaignVersionsRequest request) {request = beforeClientExecution(request);return executeGetCampaignVersions(request);}
public PutAccountSettingResult putAccountSetting(PutAccountSettingRequest request) {request = beforeClientExecution(request);return executePutAccountSetting(request);}
public CharSequence subSequence(int start, int end) {return new RawCharSequence(buffer, startPtr + start, startPtr + end);}
public static double log(double base, double x) {return Math.log(x) / Math.log(base);}
public String toString() {return String.format(Locale.ROOT,"time=%.2f sec. total (%.2f reading, %.2f sorting, %.2f merging), lines=%d, temp files=%d, merges=%d, soft ram limit=%.2f MB",totalTimeMS / 1000.0d, readTimeMS / 1000.0d, sortTimeMS.get() / 1000.0d, mergeTimeMS.get() / 1000.0d,lineCount, tempMergeFiles, mergeRounds,(double) bufferSize / MB);}
public DisableAlarmActionsResult disableAlarmActions(DisableAlarmActionsRequest request) {request = beforeClientExecution(request);return executeDisableAlarmActions(request);}
public int previousIndex() {int previous = iterator.previousIndex();if (previous >= start) {return previous - start;}return -1;}
public AcceptReservedInstancesExchangeQuoteResult acceptReservedInstancesExchangeQuote(AcceptReservedInstancesExchangeQuoteRequest request) {request = beforeClientExecution(request);return executeAcceptReservedInstancesExchangeQuote(request);}
public final RevCommit getParent(int nth) {return parents[nth];}
public String toString() {return "Cell(readerIndex=" + readerIndex + " nodeID=" + index.getNodeID()+ " isLeaf=" + index.isLeafNode() + " distanceSquared=" + distanceSquared + ")";}
public int getBATEntriesPerBlock() {return bigBlockSize / LittleEndianConsts.INT_SIZE;}
public CreateCustomerGatewayResult createCustomerGateway(CreateCustomerGatewayRequest request) {request = beforeClientExecution(request);return executeCreateCustomerGateway(request);}
public LimitTokenCountFilterFactory(Map<String, String> args) {super(args);maxTokenCount = requireInt(args, MAX_TOKEN_COUNT_KEY);consumeAllTokens = getBoolean(args, CONSUME_ALL_TOKENS_KEY, false);if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameters: " + args);}}
public SlopQueryNode(QueryNode query, int value) {if (query == null) {throw new QueryNodeError(new MessageImpl(QueryParserMessages.NODE_ACTION_NOT_SUPPORTED, "query", "null"));}this.value = value;setLeaf(false);allocate();add(query);}
public DeleteConfigurationSetTrackingOptionsResult deleteConfigurationSetTrackingOptions(DeleteConfigurationSetTrackingOptionsRequest request) {request = beforeClientExecution(request);return executeDeleteConfigurationSetTrackingOptions(request);}
public Builder() {this(16, 16);}
public ListSkillsResult listSkills(ListSkillsRequest request) {request = beforeClientExecution(request);return executeListSkills(request);}
public boolean shouldBeRecursive() {for (byte b : pathRaw)if (b == '/')return true;return false;}
public String toString(String field) {StringBuilder buffer = new StringBuilder();buffer.append("spanPosRange(");buffer.append(match.toString(field));buffer.append(", ").append(start).append(", ");buffer.append(end);buffer.append(")");return buffer.toString();}
public void write(int oneChar) {synchronized (lock) {expand(1);buf[count++] = (char) oneChar;}}
public ListStacksResult listStacks(ListStacksRequest request) {request = beforeClientExecution(request);return executeListStacks(request);}
public BundleWriter(Repository repo) {db = repo;reader = null;include = new TreeMap<>();assume = new HashSet<>();tagTargets = new HashSet<>();}
public String toString() {if (isEmpty()) {return "[]";}StringBuilder buffer = new StringBuilder(size() * 16);buffer.append('[');Iterator<?> it = iterator();while (it.hasNext()) {Object next = it.next();if (next != this) {buffer.append(next);} else {buffer.append("(this Collection)");}if (it.hasNext()) {buffer.append(", ");}}buffer.append(']');return buffer.toString();}
public CreateVpnGatewayRequest(GatewayType type) {setType(type.toString());}
public TruncateTokenFilterFactory(Map<String, String> args) {super(args);prefixLength = Byte.parseByte(get(args, PREFIX_LENGTH_KEY, "5"));if (prefixLength < 1)throw new IllegalArgumentException(PREFIX_LENGTH_KEY + " parameter must be a positive number: " + prefixLength);if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameter(s): " + args);}}
public MultiPhraseQuery build() {int[] positionsArray = new int[this.positions.size()];for (int i = 0; i < this.positions.size(); ++i) {positionsArray[i] = this.positions.get(i);}Term[][] termArraysArray = termArrays.toArray(new Term[termArrays.size()][]);return new MultiPhraseQuery(field, termArraysArray, positionsArray, slop);}
public DescribeClusterVersionsResult describeClusterVersions(DescribeClusterVersionsRequest request) {request = beforeClientExecution(request);return executeDescribeClusterVersions(request);}
public char next() {if (offset >= (end - 1)) {offset = end;return DONE;}return string.charAt(++offset);}
public final void writeChar(int val) throws IOException {writeShort(val);}
public DeleteApiMappingResult deleteApiMapping(DeleteApiMappingRequest request) {request = beforeClientExecution(request);return executeDeleteApiMapping(request);}
public String toString() {return getClass().getSimpleName() + "[" + getEntryPathString() + "]"; }
@Override public int size() {return (int) Math.min(this.size, Integer.MAX_VALUE);}
public DescribeFileSystemPolicyResult describeFileSystemPolicy(DescribeFileSystemPolicyRequest request) {request = beforeClientExecution(request);return executeDescribeFileSystemPolicy(request);}
public BatchDeleteImageResult batchDeleteImage(BatchDeleteImageRequest request) {request = beforeClientExecution(request);return executeBatchDeleteImage(request);}
public RevTag parseTag(AnyObjectId id) throws MissingObjectException,IncorrectObjectTypeException, IOException {RevObject c = parseAny(id);if (!(c instanceof RevTag))throw new IncorrectObjectTypeException(id.toObjectId(),Constants.TYPE_TAG);return (RevTag) c;}
public ParseException generateParseException() {jj_expentries.clear();boolean[] la1tokens = new boolean[34];if (jj_kind >= 0) {la1tokens[jj_kind] = true;jj_kind = -1;}for (int i = 0; i < 25; i++) {if (jj_la1[i] == jj_gen) {for (int j = 0; j < 32; j++) {if ((jj_la1_0[i] & (1<<j)) != 0) {la1tokens[j] = true;}if ((jj_la1_1[i] & (1<<j)) != 0) {la1tokens[32+j] = true;}}}}for (int i = 0; i < 34; i++) {if (la1tokens[i]) {jj_expentry = new int[1];jj_expentry[0] = i;jj_expentries.add(jj_expentry);}}jj_endpos = 0;jj_rescan_token();jj_add_error_token(0, 0);int[][] exptokseq = new int[jj_expentries.size()][];for (int i = 0; i < jj_expentries.size(); i++) {exptokseq[i] = jj_expentries.get(i);}return new ParseException(token, exptokseq, tokenImage);}
public void finish() {mState = STATE_IDLE;}
public MoPenDoRecognizeRequest() {super("MoPen", "2018-02-11", "MoPenDoRecognize", "mopen");setProtocol(ProtocolType.HTTPS);setMethod(MethodType.POST);}
public String getOldPrefix() {return this.oldPrefix;}
public Collection<Cell> getSubCells() {String[] hashes = GeohashUtils.getSubGeohashes(getGeohash());List<Cell> cells = new ArrayList<>(hashes.length);for (String hash : hashes) {cells.add(new GhCell(hash));}return cells;}
public boolean hasSourceData(int start, int end) {for (; start < end; start++)if (sourceLines[start] == 0)return false;return true;}
public Entry getEntry(final String name) throws FileNotFoundException {Entry rval = null;if (name != null) {rval = _byname.get(name);}if (rval == null) {if(_byname.containsKey("Workbook")) {throw new IllegalArgumentException("The document is really a XLS file");} else if(_byname.containsKey("PowerPoint Document")) {throw new IllegalArgumentException("The document is really a PPT file");} else if(_byname.containsKey("VisioDocument")) {throw new IllegalArgumentException("The document is really a VSD file");}throw new FileNotFoundException("no such entry: \"" + name+ "\", had: " + _byname.keySet());}return rval;}
public String getFormat(short index) {if (_movedBuiltins) {return _formats.get(index);}if(index == -1) {return null;}String fmt = _formats.size() > index ? _formats.get(index) : null;if (_builtinFormats.length > index && _builtinFormats[index] != null) {if (fmt != null) {return fmt;} else {return _builtinFormats[index];}}return fmt;}
public ListDistributionsResult listDistributions(ListDistributionsRequest request) {request = beforeClientExecution(request);return executeListDistributions(request);}
public void serialize(LittleEndianOutput out) {out.writeShort(getMode());}
public BytesRef get(int bytesID, BytesRef ref) {assert bytesStart != null : "bytesStart is null - not initialized";assert bytesID < bytesStart.length: "bytesID exceeds byteStart len: " + bytesStart.length;pool.setBytesRef(ref, bytesStart[bytesID]);return ref;}
public long get(int index) {final int o = index / 12;final int b = index % 12;final int shift = b * 5;return (blocks[o] >>> shift) & 31L;}
public DeletePlacementGroupRequest(String groupName) {setGroupName(groupName);}
public static Query parse(String[] queries, String[] fields, Analyzer analyzer)throws QueryNodeException {if (queries.length != fields.length)throw new IllegalArgumentException("queries.length != fields.length");BooleanQuery.Builder bQuery = new BooleanQuery.Builder();StandardQueryParser qp = new StandardQueryParser();qp.setAnalyzer(analyzer);for (int i = 0; i < fields.length; i++) {Query q = qp.parse(queries[i], fields[i]);if (q != null) { bQuery.add(q, BooleanClause.Occur.SHOULD);}}return bQuery.build();}
public int nextIndex() {return iterator.nextIndex() - start;}
public void serialize(LittleEndianOutput out) {out.writeInt(field_1_lineColor);out.writeShort(field_2_linePattern);out.writeShort(field_3_weight);out.writeShort(field_4_format);out.writeShort(field_5_colourPaletteIndex);}
public String toString() {return "PackWriter.State[" + phase + ", memory=" + bytesUsed + "]";}
public CreateDBSecurityGroupRequest(String dBSecurityGroupName, String dBSecurityGroupDescription) {setDBSecurityGroupName(dBSecurityGroupName);setDBSecurityGroupDescription(dBSecurityGroupDescription);}
public long get(int index) {final int o = index >>> 1;final int b = index & 1;final int shift = b << 5;return (blocks[o] >>> shift) & 4294967295L;}
public int get(int index, long[] arr, int off, int len) {return current.get(index, arr, off, len);}
public DocumentStoredFieldVisitor(Set<String> fieldsToAdd) {this.fieldsToAdd = fieldsToAdd;}
public int getRawValue(final int holder){return (holder & _mask);}
public ListCollectionsResult listCollections(ListCollectionsRequest request) {request = beforeClientExecution(request);return executeListCollections(request);}
public void setCollector(Collector collector) {this.collector = collector;}
public long seek(BytesRef target) throws IOException {current = fstEnum.seekFloor(target);return current.output;}
public GetUsagePlanKeysResult getUsagePlanKeys(GetUsagePlanKeysRequest request) {request = beforeClientExecution(request);return executeGetUsagePlanKeys(request);}
public static char toLowerCase(char c) {return c <= 'Z' ? LC[c] : c;}
public ReplaceTransitGatewayRouteResult replaceTransitGatewayRoute(ReplaceTransitGatewayRouteRequest request) {request = beforeClientExecution(request);return executeReplaceTransitGatewayRoute(request);}
public DoubleBuffer put(double c) {if (position == limit) {throw new BufferOverflowException();}backingArray[offset + position++] = c;return this;}
public int compareTo(ScoreTerm other) {if (term.bytesEquals(other.term))return 0; if (this.boost == other.boost)return other.term.compareTo(this.term);elsereturn Float.compare(this.boost, other.boost);}
public ListTagCommand tagList() {return new ListTagCommand(repo);}
public boolean isRelevant(String docName, QualityQuery query) {QRelJudgement qrj = judgements.get(query.getQueryID());return qrj!=null && qrj.isRelevant(docName);}
public VerifyDomainIdentityResult verifyDomainIdentity(VerifyDomainIdentityRequest request) {request = beforeClientExecution(request);return executeVerifyDomainIdentity(request);}
public FeatProtection() {securityDescriptor = new byte[0];}
public ATNConfig precedenceTransition(ATNConfig config,PrecedencePredicateTransition pt,boolean collectPredicates,boolean inContext,boolean fullCtx){if ( debug ) {System.out.println("PRED (collectPredicates="+collectPredicates+") "+pt.precedence+">=_p"+", ctx dependent=true");if ( parser != null ) {System.out.println("context surrounding pred is "+parser.getRuleInvocationStack());}}ATNConfig c = null;if (collectPredicates && inContext) {if ( fullCtx ) {int currentPosition = _input.index();_input.seek(_startIndex);boolean predSucceeds = evalSemanticContext(pt.getPredicate(), _outerContext, config.alt, fullCtx);_input.seek(currentPosition);if ( predSucceeds ) {c = new ATNConfig(config, pt.target); }}else {SemanticContext newSemCtx =SemanticContext.and(config.semanticContext, pt.getPredicate());c = new ATNConfig(config, pt.target, newSemCtx);}}else {c = new ATNConfig(config, pt.target);}if ( debug ) System.out.println("config from pred transition="+c);return c;}
public StringBuilder insert(int offset, char c) {insert0(offset, c);return this;}
public String toFormulaString(){return ":";}
public ClassificationResult(T assignedClass, double score) {this.assignedClass = assignedClass;this.score = score;}
public CreateResolverEndpointResult createResolverEndpoint(CreateResolverEndpointRequest request) {request = beforeClientExecution(request);return executeCreateResolverEndpoint(request);}
public synchronized int indexOf(String subString, int start) {return super.indexOf(subString, start);}
public TableRestoreStatus restoreTableFromClusterSnapshot(RestoreTableFromClusterSnapshotRequest request) {request = beforeClientExecution(request);return executeRestoreTableFromClusterSnapshot(request);}
public EscherDgRecord createDgRecord() {EscherDgRecord dg = new EscherDgRecord();dg.setRecordId( EscherDgRecord.RECORD_ID );short dgId = findNewDrawingGroupId();dg.setOptions( (short) ( dgId << 4 ) );dg.setNumShapes( 0 );dg.setLastMSOSPID( -1 );drawingGroups.add(dg);dgg.addCluster( dgId, 0 );dgg.setDrawingsSaved( dgg.getDrawingsSaved() + 1 );return dg;}
public String getSignificantDecimalDigits() {return Long.toString(_wholePart);}
public String subscriptionId() {return this.subscriptionId;}
public SimpleQQParser(String qqNames[], String indexField) {this.qqNames = qqNames;this.indexField = indexField;}
public static final int endOfParagraph(byte[] b, int start) {int ptr = start;final int sz = b.length;while (ptr < sz && (b[ptr] != '\n' && b[ptr] != '\r'))ptr = nextLF(b, ptr);if (ptr > start && b[ptr - 1] == '\n')ptr--;if (ptr > start && b[ptr - 1] == '\r')ptr--;return ptr;}
public LongBuffer duplicate() {ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());LongToByteBufferAdapter buf = new LongToByteBufferAdapter(bb);buf.limit = limit;buf.position = position;buf.mark = mark;return buf;}
public void skipBytes(long count) {pos += count;}
public HSSFName createName(){NameRecord nameRecord = workbook.createName();HSSFName newName = new HSSFName(this, nameRecord);names.add(newName);return newName;}
public StringBuffer insert(int index, boolean b) {return insert(index, b ? "true" : "false");}
public int getLevelForDistance(double dist) {if (dist == 0)return maxLevels;final int level = GeohashUtils.lookupHashLenForWidthHeight(dist, dist);return Math.max(Math.min(level, maxLevels), 1);}
public ListNamedQueriesResult listNamedQueries(ListNamedQueriesRequest request) {request = beforeClientExecution(request);return executeListNamedQueries(request);}
public void copyTo(ByteBuffer b) {b.put(toHexByteArray());}
public CellRangeAddress copy() {return new CellRangeAddress(getFirstRow(), getLastRow(), getFirstColumn(), getLastColumn());}
public AreaErrPtg() {unused1 = 0;unused2 = 0;}
public BatchDetectSentimentResult batchDetectSentiment(BatchDetectSentimentRequest request) {request = beforeClientExecution(request);return executeBatchDetectSentiment(request);}
public boolean equals(Object o) {if (o instanceof HSSFRichTextString) {return _string.equals(((HSSFRichTextString)o)._string);}return false;}
public SetTransition(ATNState target, IntervalSet set) {super(target);if ( set == null ) set = IntervalSet.of(Token.INVALID_TYPE);this.set = set;}
public DescribeAppResult describeApp(DescribeAppRequest request) {request = beforeClientExecution(request);return executeDescribeApp(request);}
public String format(Passage passages[], String content) {StringBuilder sb = new StringBuilder();int pos = 0;for (Passage passage : passages) {if (passage.getStartOffset() > pos && pos > 0) {sb.append(ellipsis);}pos = passage.getStartOffset();for (int i = 0; i < passage.getNumMatches(); i++) {int start = passage.getMatchStarts()[i];assert start >= pos && start < passage.getEndOffset();append(sb, content, pos, start);int end = passage.getMatchEnds()[i];assert end > start;while (i + 1 < passage.getNumMatches() && passage.getMatchStarts()[i+1] < end) {end = passage.getMatchEnds()[++i];}end = Math.min(end, passage.getEndOffset()); sb.append(preTag);append(sb, content, start, end);sb.append(postTag);pos = end;}append(sb, content, pos, Math.max(pos, passage.getEndOffset()));pos = passage.getEndOffset();}return sb.toString();}
public final ValueEval evaluate(ValueEval[] args, int srcRowIndex, int srcColumnIndex) {switch (args.length) {case 1:return evaluate(srcRowIndex, srcColumnIndex, args[0]);case 2:return evaluate(srcRowIndex, srcColumnIndex, args[0], args[1]);}return ErrorEval.VALUE_INVALID;}
public EndSubRecord clone() {return copy();}
public void decode(byte[] blocks, int blocksOffset, long[] values, int valuesOffset, int iterations) {for (int j = 0; j < iterations; ++j) {final byte block = blocks[blocksOffset++];values[valuesOffset++] = (block >>> 6) & 3;values[valuesOffset++] = (block >>> 4) & 3;values[valuesOffset++] = (block >>> 2) & 3;values[valuesOffset++] = block & 3;}}
public OrderedATNConfigSet() {this.configLookup = new LexerConfigHashSet();}
public synchronized int codePointAt(int index) {return super.codePointAt(index);}
public ItalianLightStemFilterFactory(Map<String,String> args) {super(args);if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameters: " + args);}}
public String toString(String field) {StringBuilder buffer = new StringBuilder();if (!term.field().equals(field)) {buffer.append(term.field());buffer.append(":");}buffer.append(term.text());return buffer.toString();}
public EpsilonTransition(ATNState target, int outermostPrecedenceReturn) {super(target);this.outermostPrecedenceReturn = outermostPrecedenceReturn;}
public void serialize(LittleEndianOutput out) {out.writeInt(getPositionOfBof());out.writeShort(field_2_option_flags);String name = field_5_sheetname;out.writeByte(name.length());out.writeByte(field_4_isMultibyteUnicode);if (isMultibyte()) {StringUtil.putUnicodeLE(name, out);} else {StringUtil.putCompressedUnicode(name, out);}}
public String toString(){StringBuilder buffer = new StringBuilder();buffer.append("[IFMT]\n");buffer.append("    .formatIndex          = ").append("0x").append(HexDump.toHex(  getFormatIndex ())).append(" (").append( getFormatIndex() ).append(" )");buffer.append(System.getProperty("line.separator"));buffer.append("[/IFMT]\n");return buffer.toString();}
public GetUsagePlanResult getUsagePlan(GetUsagePlanRequest request) {request = beforeClientExecution(request);return executeGetUsagePlan(request);}
public String toString(){StringBuilder sb = new StringBuilder();sb.append( getText() ).append( '(' ).append( boost ).append( ")(" );for( Toffs to : termsOffsets ){sb.append( to );}sb.append( ')' );return sb.toString();}
public ListUserGroupsResult listUserGroups(ListUserGroupsRequest request) {request = beforeClientExecution(request);return executeListUserGroups(request);}
public long readLong() throws IOException {return primitiveTypes.readLong();}
public boolean containsKey(Object name) {return get(name) != null;}
public void incrementDrawingsSaved(){dgg.setDrawingsSaved(dgg.getDrawingsSaved()+1);}
public int get() {if (position == limit) {throw new BufferUnderflowException();}return byteBuffer.getInt(position++ * SizeOf.INT);}
public static String fromLong(Long value) {return Long.toString(value);}
public boolean isCaseSensitive() {return false;}
public int lastLength() {return lastLength;}
public SubmoduleAddCommand setURI(String uri) {this.uri = uri;return this;}
@Override public ListIterator<E> listIterator() {synchronized (mutex) {return list.listIterator();}}
public void write(int b) throws IOException {try {beginWrite();dst.write(b);} catch (InterruptedIOException e) {throw writeTimedOut(e);} finally {endWrite();}}
public ASCIIFoldingFilter(TokenStream input, boolean preserveOriginal){super(input);this.preserveOriginal = preserveOriginal;}
public CJKBigramFilterFactory(Map<String,String> args) {super(args);int flags = 0;if (getBoolean(args, "han", true)) {flags |= CJKBigramFilter.HAN;}if (getBoolean(args, "hiragana", true)) {flags |= CJKBigramFilter.HIRAGANA;}if (getBoolean(args, "katakana", true)) {flags |= CJKBigramFilter.KATAKANA;}if (getBoolean(args, "hangul", true)) {flags |= CJKBigramFilter.HANGUL;}this.flags = flags;this.outputUnigrams = getBoolean(args, "outputUnigrams", false);if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameters: " + args);}}
public UpdateResourceResult updateResource(UpdateResourceRequest request) {request = beforeClientExecution(request);return executeUpdateResource(request);}
public String toString() {return getClass().getName() + " [" +_name.getNameText() +"]";}
public String toString(){StringBuilder buffer = new StringBuilder();buffer.append("[SINDEX]\n");buffer.append("    .index                = ").append("0x").append(HexDump.toHex(  getIndex ())).append(" (").append( getIndex() ).append(" )");buffer.append(System.getProperty("line.separator"));buffer.append("[/SINDEX]\n");return buffer.toString();}
public long ramBytesUsed() {long sizeInBytes = 0;for(FieldIndexData entry : fields.values()) {sizeInBytes += entry.ramBytesUsed();}return sizeInBytes;}
public void setStorageId(int storageId) {field_5_stream_id = storageId;}
public String toString() {return this.getClass().getSimpleName() + "@" + directory + " lockFactory=" + lockFactory;}
public String toString(){StringBuilder buffer = new StringBuilder();buffer.append("[CALCMODE]\n");buffer.append("    .calcmode       = ").append(Integer.toHexString(getCalcMode())).append("\n");buffer.append("[/CALCMODE]\n");return buffer.toString();}
public static Console getConsole() {return console;}
public DescribeFleetAttributesResult describeFleetAttributes(DescribeFleetAttributesRequest request) {request = beforeClientExecution(request);return executeDescribeFleetAttributes(request);}
public GetResolverRuleResult getResolverRule(GetResolverRuleRequest request) {request = beforeClientExecution(request);return executeGetResolverRule(request);}
public RevFlagSet() {active = new ArrayList<>();}
public JapaneseKatakanaStemFilterFactory(Map<String,String> args) {super(args);minimumLength = getInt(args, MINIMUM_LENGTH_PARAM, JapaneseKatakanaStemFilter.DEFAULT_MINIMUM_LENGTH);if (minimumLength < 2) {throw new IllegalArgumentException("Illegal " + MINIMUM_LENGTH_PARAM + " " + minimumLength + " (must be 2 or greater)");}if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameters: " + args);}}
public String[] lemmatize(String[] words, String[] postags) {String[] lemmas = null;String[] maxEntLemmas = null;if (dictionaryLemmatizer != null) {lemmas = dictionaryLemmatizer.lemmatize(words, postags);for (int i = 0; i < lemmas.length; ++i) {if (lemmas[i].equals("O")) {   if (lemmatizerME != null) {  if (maxEntLemmas == null) {maxEntLemmas = lemmatizerME.lemmatize(words, postags);}if ("_".equals(maxEntLemmas[i])) {lemmas[i] = words[i];    } else {lemmas[i] = maxEntLemmas[i];}} else {                     lemmas[i] = words[i];      }}}} else {                           maxEntLemmas = lemmatizerME.lemmatize(words, postags);for (int i = 0 ; i < maxEntLemmas.length ; ++i) {if ("_".equals(maxEntLemmas[i])) {maxEntLemmas[i] = words[i];  }}lemmas = maxEntLemmas;}return lemmas;}
public IndexEnum(FST<Long> fst) {fstEnum = new BytesRefFSTEnum<>(fst);}
public CustomAvailabilityZone createCustomAvailabilityZone(CreateCustomAvailabilityZoneRequest request) {request = beforeClientExecution(request);return executeCreateCustomAvailabilityZone(request);}
public CreateKeyPairResult createKeyPair(CreateKeyPairRequest request) {request = beforeClientExecution(request);return executeCreateKeyPair(request);}
public IntervalSet addAll(IntSet set) {if ( set==null ) {return this;}if (set instanceof IntervalSet) {IntervalSet other = (IntervalSet)set;int n = other.intervals.size();for (int i = 0; i < n; i++) {Interval I = other.intervals.get(i);this.add(I.a,I.b);}}else {for (int value : set.toList()) {add(value);}}return this;}
public GetMeetingResult getMeeting(GetMeetingRequest request) {request = beforeClientExecution(request);return executeGetMeeting(request);}
public void seekExact(BytesRef target, TermState otherState) {if (!target.equals(term)) {state.copyFrom(otherState);term = BytesRef.deepCopyOf(target);seekPending = true;}}
public void execute(Lexer lexer) {action.execute(lexer);}
public LooseRef peel(ObjectIdRef newLeaf) {ObjectId peeledObjectId = newLeaf.getPeeledObjectId();ObjectId objectId = getObjectId();if (peeledObjectId != null) {return new LoosePeeledTag(snapShot, getName(),objectId, peeledObjectId);}return new LooseNonTag(snapShot, getName(), objectId);}
public CreateVpnGatewayRequest(String type) {setType(type);}
public ModifyFleetResult modifyFleet(ModifyFleetRequest request) {request = beforeClientExecution(request);return executeModifyFleet(request);}
public String toString() {StringBuilder buffer = new StringBuilder();buffer.append("[NOTE]\n");buffer.append("    .row    = ").append(field_1_row).append("\n");buffer.append("    .col    = ").append(field_2_col).append("\n");buffer.append("    .flags  = ").append(field_3_flags).append("\n");buffer.append("    .shapeid= ").append(field_4_shapeid).append("\n");buffer.append("    .author = ").append(field_6_author).append("\n");buffer.append("[/NOTE]\n");return buffer.toString();}
public DescribeEndpointsResult describeEndpoints(DescribeEndpointsRequest request) {request = beforeClientExecution(request);return executeDescribeEndpoints(request);}
public boolean equals(ATNConfig other) {if (this == other) {return true;}else if (!(other instanceof LexerATNConfig)) {return false;}LexerATNConfig lexerOther = (LexerATNConfig)other;if (passedThroughNonGreedyDecision != lexerOther.passedThroughNonGreedyDecision) {return false;}if (!ObjectEqualityComparator.INSTANCE.equals(lexerActionExecutor, lexerOther.lexerActionExecutor)) {return false;}return super.equals(other);}
public ListInstanceFleetsResult listInstanceFleets(ListInstanceFleetsRequest request) {request = beforeClientExecution(request);return executeListInstanceFleets(request);}
public int compareTo(File another) {return this.getPath().compareTo(another.getPath());}
public DeleteCustomerGatewayRequest(String customerGatewayId) {setCustomerGatewayId(customerGatewayId);}
public CreateDeliveryStreamResult createDeliveryStream(CreateDeliveryStreamRequest request) {request = beforeClientExecution(request);return executeCreateDeliveryStream(request);}
public AllocatePrivateVirtualInterfaceResult allocatePrivateVirtualInterface(AllocatePrivateVirtualInterfaceRequest request) {request = beforeClientExecution(request);return executeAllocatePrivateVirtualInterface(request);}
public void close() throws IOException {super.close();}
public CreateBranchCommand setName(String name) {checkCallable();this.name = name;return this;}
public DescribeTableResult describeTable(String tableName) {return describeTable(new DescribeTableRequest().withTableName(tableName));}
public PipedInputStream(PipedOutputStream out, int pipeSize) throws IOException {this(pipeSize);connect(out);}
public String toString() {StringBuilder sb = new StringBuilder("[ArrayPtg]\n");sb.append("nRows = ").append(getRowCount()).append("\n");sb.append("nCols = ").append(getColumnCount()).append("\n");if (_arrayValues == null) {sb.append("  #values#uninitialised#\n");} else {sb.append("  ").append(toFormulaString());}return sb.toString();}
public ValueEval getItem(int index) {if (index != 0) {throw new RuntimeException("Invalid index ("+ index + ") only zero is allowed");}return _value;}
public ImportSnapshotResult importSnapshot(ImportSnapshotRequest request) {request = beforeClientExecution(request);return executeImportSnapshot(request);}
public int readDataSize() {readPlain(buffer, 0, LittleEndianConsts.SHORT_SIZE);int dataSize = LittleEndian.getUShort(buffer, 0);ccis.setNextRecordSize(dataSize);return dataSize;}
public DeleteIdentitiesResult deleteIdentities(DeleteIdentitiesRequest request) {request = beforeClientExecution(request);return executeDeleteIdentities(request);}
public boolean changeExternalReference(String oldUrl, String newUrl) {return linkTable.changeExternalReference(oldUrl, newUrl);}
public WindowProtectRecord(boolean protect) {this(0);setProtect(protect);}
public PasswordRev4Record(int pw) {field_1_password = pw;}
public DeleteSnapshotResult deleteSnapshot(DeleteSnapshotRequest request) {request = beforeClientExecution(request);return executeDeleteSnapshot(request);}
public DescribeHsmConfigurationsResult describeHsmConfigurations() {return describeHsmConfigurations(new DescribeHsmConfigurationsRequest());}
public String getName() {return String.format(Locale.ROOT, "Dirichlet(%f)", getMu());}
public StartStreamProcessorResult startStreamProcessor(StartStreamProcessorRequest request) {request = beforeClientExecution(request);return executeStartStreamProcessor(request);}
public boolean isEmpty() {return size == 0;}
public Float getAndIncrement(String key) {String key2 = key.trim().toLowerCase(locale);TSTNode node = getNode(key2);if (node == null) {return null;}Float aux = (Float) (node.data);if (aux == null) {aux = 1f;} else {aux = (float) (aux.intValue() + 1);}put(key2, aux);return aux;}
public String toString() {return "more";}
public int[] init() {if (perField.postingsArray == null) {perField.postingsArray = perField.createPostingsArray(2);perField.newPostingsArray();bytesUsed.addAndGet(perField.postingsArray.size * perField.postingsArray.bytesPerPosting());}return perField.postingsArray.textStarts;}
public GetVariablesResult getVariables(GetVariablesRequest request) {request = beforeClientExecution(request);return executeGetVariables(request);}
public void dumpDFA() {synchronized (_interp.decisionToDFA) {boolean seenOne = false;for (int d = 0; d < _interp.decisionToDFA.length; d++) {DFA dfa = _interp.decisionToDFA[d];if ( !dfa.states.isEmpty() ) {if ( seenOne ) System.out.println();System.out.println("Decision " + dfa.decision + ":");System.out.print(dfa.toString(getVocabulary()));seenOne = true;}}}}
public CreateEgressOnlyInternetGatewayResult createEgressOnlyInternetGateway(CreateEgressOnlyInternetGatewayRequest request) {request = beforeClientExecution(request);return executeCreateEgressOnlyInternetGateway(request);}
public int read() throws IOException {synchronized (lock) {if (!isOpen()) {throw new IOException("InputStreamReader is closed");}char[] buf = new char[1];return read(buf, 0, 1) != -1 ? buf[0] : -1;}}
public GetQualificationScoreResult getQualificationScore(GetQualificationScoreRequest request) {request = beforeClientExecution(request);return executeGetQualificationScore(request);}
public DeleteRuleVersionResult deleteRuleVersion(DeleteRuleVersionRequest request) {request = beforeClientExecution(request);return executeDeleteRuleVersion(request);}
public ValueEval evaluate(int srcRowIndex, int srcColumnIndex, ValueEval numberVE) {final String hex;if (numberVE instanceof RefEval) {RefEval re = (RefEval) numberVE;hex = OperandResolver.coerceValueToString(re.getInnerValueEval(re.getFirstSheetIndex()));} else {hex = OperandResolver.coerceValueToString(numberVE);}try {return new NumberEval(BaseNumberUtils.convertToDecimal(hex, HEXADECIMAL_BASE, MAX_NUMBER_OF_PLACES));}  catch (IllegalArgumentException e) {return ErrorEval.NUM_ERROR;}}
public IndexFormatTooOldException(String resourceDescription, int version, int minVersion, int maxVersion) {super("Format version is not supported (resource " + resourceDescription + "): " +version + " (needs to be between " + minVersion + " and " + maxVersion +"). This version of Lucene only supports indexes created with release 8.0 and later.");this.resourceDescription = resourceDescription;this.version = version;this.minVersion = minVersion;this.maxVersion = maxVersion;this.reason = null;}
public NoteMapMerger(Repository db, NoteMerger noteMerger,MergeStrategy nonNotesMergeStrategy) {this.db = db;this.reader = db.newObjectReader();this.inserter = db.newObjectInserter();this.noteMerger = noteMerger;this.nonNotesMergeStrategy = nonNotesMergeStrategy;this.objectIdPrefix = new MutableObjectId();}
public String toString() {return getClass().getSimpleName() + "(bitsPerValue=" + bitsPerValue+ ",size=" + size() + ",blocks=" + blocks.length + ")";}
public String toString() {StringBuilder buffer = new StringBuilder();buffer.append("[DELTA]\n");buffer.append("    .maxchange = ").append(getMaxChange()).append("\n");buffer.append("[/DELTA]\n");return buffer.toString();}
public String toString() {return toString(0);}
public DeleteVpcPeeringAuthorizationResult deleteVpcPeeringAuthorization(DeleteVpcPeeringAuthorizationRequest request) {request = beforeClientExecution(request);return executeDeleteVpcPeeringAuthorization(request);}
public DescribeWorkteamResult describeWorkteam(DescribeWorkteamRequest request) {request = beforeClientExecution(request);return executeDescribeWorkteam(request);}
public boolean isPeeled() {return false;}
public static BytesRef toBytesRef(IntsRef input, BytesRefBuilder scratch) {scratch.grow(input.length);for(int i=0;i<input.length;i++) {int value = input.ints[i+input.offset];assert value >= Byte.MIN_VALUE && value <= 255: "value " + value + " doesn't fit into byte";scratch.setByteAt(i, (byte) value);}scratch.setLength(input.length);return scratch.get();}
public static void registerFunction(String name, FreeRefFunction func){AnalysisToolPak.registerFunction(name, func);}
public TermData add(TermData t1, TermData t2) {if (t1 == NO_OUTPUT) {return t2;} else if (t2 == NO_OUTPUT) {return t1;}TermData ret;if (t2.bytes != null || t2.docFreq > 0) {ret = new TermData(t2.bytes, t2.docFreq, t2.totalTermFreq);} else {ret = new TermData(t1.bytes, t1.docFreq, t1.totalTermFreq);}return ret;}
public ByteArrayBackedDataSource(byte[] data, int size) { this.buffer = data;this.size = size;}
public DescribeImageBuildersResult describeImageBuilders(DescribeImageBuildersRequest request) {request = beforeClientExecution(request);return executeDescribeImageBuilders(request);}
public MissingFormatArgumentException(String s) {if (s == null) {throw new NullPointerException();}this.s = s;}
@Override public int size() {return BoundedMap.this.size();}
public SimpleMergedSegmentWarmer(InfoStream infoStream) {this.infoStream = infoStream;}
public static void writeUnicodeString(LittleEndianOutput out, String value) {int nChars = value.length();out.writeShort(nChars);boolean is16Bit = hasMultibyte(value);out.writeByte(is16Bit ? 0x01 : 0x00);if (is16Bit) {putUnicodeLE(value, out);} else {putCompressedUnicode(value, out);}}
public ObjectId getNewId() {return newId;}
public PorterStemFilter create(TokenStream input) {return new PorterStemFilter(input);}
public boolean equals(Object o) {return o instanceof FileKey && path.equals(((FileKey) o).path);}
public IllegalFormatFlagsException(String flags) {if (flags == null) {throw new NullPointerException();}this.flags = flags;}
public TokenStream create(TokenStream input) {return new FinnishLightStemFilter(input);}
public final ByteBuffer encode(CharBuffer in) throws CharacterCodingException {if (in.remaining() == 0) {return ByteBuffer.allocate(0);}reset();int length = (int) (in.remaining() * averageBytesPerChar);ByteBuffer output = ByteBuffer.allocate(length);CoderResult result = null;while (true) {result = encode(in, output, false);if (result==CoderResult.UNDERFLOW) {break;} else if (result==CoderResult.OVERFLOW) {output = allocateMore(output);continue;}checkCoderResult(result);}result = encode(in, output, true);checkCoderResult(result);while (true) {result = flush(output);if (result==CoderResult.UNDERFLOW) {output.flip();break;} else if (result==CoderResult.OVERFLOW) {output = allocateMore(output);continue;}checkCoderResult(result);output.flip();if (result.isMalformed()) {throw new MalformedInputException(result.length());} else if (result.isUnmappable()) {throw new UnmappableCharacterException(result.length());}break;}status = READY;finished = true;return output;}
public CreateDiskFromSnapshotResult createDiskFromSnapshot(CreateDiskFromSnapshotRequest request) {request = beforeClientExecution(request);return executeCreateDiskFromSnapshot(request);}
public UploadPackInternalServerErrorException(Throwable why) {initCause(why);}
public ScandinavianNormalizationFilterFactory(Map<String, String> args) {super(args);if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameters: " + args);}}
public int compareTo( Toffs other ) {int diff = getStartOffset() - other.getStartOffset();if ( diff != 0 ) {return diff;}return getEndOffset() - other.getEndOffset();}
public XPathElement(String nodeName) {this.nodeName = nodeName;}
public UpdateDomainContactResult updateDomainContact(UpdateDomainContactRequest request) {request = beforeClientExecution(request);return executeUpdateDomainContact(request);}
public AssociateQualificationWithWorkerResult associateQualificationWithWorker(AssociateQualificationWithWorkerRequest request) {request = beforeClientExecution(request);return executeAssociateQualificationWithWorker(request);}
public CreateRepositoryResult createRepository(CreateRepositoryRequest request) {request = beforeClientExecution(request);return executeCreateRepository(request);}
public DeleteConfigurationSetEventDestinationResult deleteConfigurationSetEventDestination(DeleteConfigurationSetEventDestinationRequest request) {request = beforeClientExecution(request);return executeDeleteConfigurationSetEventDestination(request);}
public HCenterRecord(RecordInputStream in) {field_1_hcenter = in.readShort();}
public FloatBuffer put(float c) {throw new ReadOnlyBufferException();}
public SimpleFraction(int numerator, int denominator){this.numerator = numerator;this.denominator = denominator;}
public ListCandidatesForAutoMLJobResult listCandidatesForAutoMLJob(ListCandidatesForAutoMLJobRequest request) {request = beforeClientExecution(request);return executeListCandidatesForAutoMLJob(request);}
public void verifyBelongsToWorkbook(HSSFWorkbook wb) {if(wb.getWorkbook() != _workbook) {throw new IllegalArgumentException("This Style does not belong to the supplied Workbook. Are you trying to assign a style from one workbook to the cell of a differnt workbook?");}}
public static FileKey lenient(File directory, FS fs) {final File gitdir = resolve(directory, fs);return new FileKey(gitdir != null ? gitdir : directory, fs);}
public DescribeClusterVersionsResult describeClusterVersions() {return describeClusterVersions(new DescribeClusterVersionsRequest());}
public static Path categoriesLineFile(Path f) {Path dir = f.toAbsolutePath().getParent();String categoriesName = "categories-"+f.getFileName();return dir.resolve(categoriesName);}
public ATN(ATNType grammarType, int maxTokenType) {this.grammarType = grammarType;this.maxTokenType = maxTokenType;}
public ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {Arrays.checkOffsetAndCount(dst.length, dstOffset, byteCount);if (byteCount > remaining()) {throw new BufferUnderflowException();}for (int i = dstOffset; i < dstOffset + byteCount; ++i) {dst[i] = get();}return this;}
public void setPackedGitWindowSize(int newSize) {packedGitWindowSize = newSize;}
public ListInstancesResult listInstances(ListInstancesRequest request) {request = beforeClientExecution(request);return executeListInstances(request);}
public InitiateJobRequest(String vaultName, JobParameters jobParameters) {setVaultName(vaultName);setJobParameters(jobParameters);}
public void setMBPerSec(double mbPerSec) {this.mbPerSec = mbPerSec;minPauseCheckBytes = (long) ((MIN_PAUSE_CHECK_MSEC / 1000.0) * mbPerSec * 1024 * 1024);}
public ValueEval evaluate(ValueEval[] args, OperationEvaluationContext ec) {if (args.length == 2) {return evaluate(ec.getRowIndex(), ec.getColumnIndex(), args[0], args[1]);}if (args.length == 3) {return evaluate(ec.getRowIndex(), ec.getColumnIndex(), args[0], args[1], args[2]);}return ErrorEval.VALUE_INVALID;}
public void remove() {iterator.remove();subList.sizeChanged(false);end--;}
public UpdateFleetMetadataResult updateFleetMetadata(UpdateFleetMetadataRequest request) {request = beforeClientExecution(request);return executeUpdateFleetMetadata(request);}
public String toString() {return a+".."+b;}
public StopTransformJobResult stopTransformJob(StopTransformJobRequest request) {request = beforeClientExecution(request);return executeStopTransformJob(request);}
public ListFiltersResult listFilters(ListFiltersRequest request) {request = beforeClientExecution(request);return executeListFilters(request);}
public String toFormulaString(String[] operands) {return "(" + operands[0] + ")";}
public NRTCachingDirectory(Directory delegate, double maxMergeSizeMB, double maxCachedMB) {super(delegate);maxMergeSizeBytes = (long) (maxMergeSizeMB * 1024 * 1024);maxCachedBytes = (long) (maxCachedMB * 1024 * 1024);}
public UpdateApiResult updateApi(UpdateApiRequest request) {request = beforeClientExecution(request);return executeUpdateApi(request);}
public String toString(){StringBuilder buffer = new StringBuilder();buffer.append("[DAT]\n");buffer.append("    .options              = ").append("0x").append(HexDump.toHex(  getOptions ())).append(" (").append( getOptions() ).append(" )");buffer.append(System.getProperty("line.separator"));buffer.append("         .horizontalBorder         = ").append(isHorizontalBorder()).append('\n');buffer.append("         .verticalBorder           = ").append(isVerticalBorder()).append('\n');buffer.append("         .border                   = ").append(isBorder()).append('\n');buffer.append("         .showSeriesKey            = ").append(isShowSeriesKey()).append('\n');buffer.append("[/DAT]\n");return buffer.toString();}
public String toString(Vocabulary vocabulary) {if (s0 == null) {return "";}DFASerializer serializer = new DFASerializer(this, vocabulary);return serializer.toString();}
public UpdateHITReviewStatusResult updateHITReviewStatus(UpdateHITReviewStatusRequest request) {request = beforeClientExecution(request);return executeUpdateHITReviewStatus(request);}
public UpdateJourneyResult updateJourney(UpdateJourneyRequest request) {request = beforeClientExecution(request);return executeUpdateJourney(request);}
public synchronized Set<K> keySet() {Set<K> ks = keySet;return (ks != null) ? ks : (keySet = new KeySet());}
public final float[] array() {return protectedArray();}
public void clear() {value = null;}
public DiscoverInputSchemaResult discoverInputSchema(DiscoverInputSchemaRequest request) {request = beforeClientExecution(request);return executeDiscoverInputSchema(request);}
public CreateTicketRequest() {super("Ccs", "2017-10-01", "CreateTicket", "ccs");setMethod(MethodType.POST);}
public CreateDirectConnectGatewayAssociationProposalResult createDirectConnectGatewayAssociationProposal(CreateDirectConnectGatewayAssociationProposalRequest request) {request = beforeClientExecution(request);return executeCreateDirectConnectGatewayAssociationProposal(request);}
public static int getDataSize() {return 12;}
public boolean shouldBeRecursive() {return true;}
public DetectCustomLabelsResult detectCustomLabels(DetectCustomLabelsRequest request) {request = beforeClientExecution(request);return executeDetectCustomLabels(request);}
public long ramBytesUsed() {long size = 0;for (Map.Entry<String,DocValuesProducer> entry : formats.entrySet()) {size += (entry.getKey().length() * Character.BYTES) + entry.getValue().ramBytesUsed();}return size;}
@Override public int size() {return totalSize;}
public ClusterParameterGroup createClusterParameterGroup(CreateClusterParameterGroupRequest request) {request = beforeClientExecution(request);return executeCreateClusterParameterGroup(request);}
public Ref3DPxg(int externalWorkbookNumber, SheetIdentifier sheetName, CellReference c) {super(c);this.externalWorkbookNumber = externalWorkbookNumber;this.firstSheetName = sheetName.getSheetIdentifier().getName();if (sheetName instanceof SheetRangeIdentifier) {this.lastSheetName = ((SheetRangeIdentifier)sheetName).getLastSheetIdentifier().getName();} else {this.lastSheetName = null;}}
public DeleteTrialComponentResult deleteTrialComponent(DeleteTrialComponentRequest request) {request = beforeClientExecution(request);return executeDeleteTrialComponent(request);}
public WeightedSpanTerm getWeightedSpanTerm(String token) {return fieldWeightedSpanTerms.get(token);}
public Matcher matcher(CharSequence input) {return new Matcher(this, input);}
public Long contentLength() {return this.contentLength;}
public PutMailboxPermissionsResult putMailboxPermissions(PutMailboxPermissionsRequest request) {request = beforeClientExecution(request);return executePutMailboxPermissions(request);}
public DBSecurityGroup createDBSecurityGroup(CreateDBSecurityGroupRequest request) {request = beforeClientExecution(request);return executeCreateDBSecurityGroup(request);}
public void serialize(LittleEndianOutput out) {out.writeShort(sid);out.writeShort(_cbFContinued);if (_linkPtg == null) {out.writeShort(0);} else {int formulaSize = _linkPtg.getSize();int linkSize = formulaSize + 6;if (_unknownPostFormulaByte != null) {linkSize++;}out.writeShort(linkSize);out.writeShort(formulaSize);out.writeInt(_unknownPreFormulaInt);_linkPtg.write(out);if (_unknownPostFormulaByte != null) {out.writeByte(_unknownPostFormulaByte.intValue());}}out.writeShort(_cLines);out.writeShort(_iSel);out.writeShort(_flags);out.writeShort(_idEdit);if(_dropData != null) {_dropData.serialize(out);}if(_rgLines != null) {for(String str : _rgLines){StringUtil.writeUnicodeString(out, str);}}if(_bsels != null) {for(boolean val : _bsels){out.writeByte(val ? 1 : 0);}}}
public DeleteRuleResult deleteRule(DeleteRuleRequest request) {request = beforeClientExecution(request);return executeDeleteRule(request);}
public GlobalReplicationGroup increaseNodeGroupsInGlobalReplicationGroup(IncreaseNodeGroupsInGlobalReplicationGroupRequest request) {request = beforeClientExecution(request);return executeIncreaseNodeGroupsInGlobalReplicationGroup(request);}
public CommonRoaRequest(String product) {super(product);setSysAcceptFormat(FormatType.JSON);}
public CreateRequestValidatorResult createRequestValidator(CreateRequestValidatorRequest request) {request = beforeClientExecution(request);return executeCreateRequestValidator(request);}
public LongBuffer duplicate() {return copy(this, mark);}
public void println(long l) {println(String.valueOf(l));}
public DeleteDirectConnectGatewayAssociationResult deleteDirectConnectGatewayAssociation(DeleteDirectConnectGatewayAssociationRequest request) {request = beforeClientExecution(request);return executeDeleteDirectConnectGatewayAssociation(request);}
public int getValue(final int holder){return getRawValue(holder) >>> _shift_count;}
public ListRoutingProfilesResult listRoutingProfiles(ListRoutingProfilesRequest request) {request = beforeClientExecution(request);return executeListRoutingProfiles(request);}
public long get(int index) {final int o = index >>> 4;final int b = index & 15;final int shift = b << 2;return (blocks[o] >>> shift) & 15L;}
public StandardSyntaxParser(StandardSyntaxParserTokenManager tm) {token_source = tm;token = new Token();jj_ntk = -1;jj_gen = 0;for (int i = 0; i < 25; i++) jj_la1[i] = -1;for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();}
public AcceptQualificationRequestResult acceptQualificationRequest(AcceptQualificationRequestRequest request) {request = beforeClientExecution(request);return executeAcceptQualificationRequest(request);}
public StartChatContactResult startChatContact(StartChatContactRequest request) {request = beforeClientExecution(request);return executeStartChatContact(request);}
public GetDataEndpointResult getDataEndpoint(GetDataEndpointRequest request) {request = beforeClientExecution(request);return executeGetDataEndpoint(request);}
public static double coerceValueToDouble(ValueEval ev) throws EvaluationException {if (ev == BlankEval.instance) {return 0.0;}if (ev instanceof NumericValueEval) {return ((NumericValueEval)ev).getNumberValue();}if (ev instanceof StringEval) {String sval = ((StringEval) ev).getStringValue();Double dd = parseDouble(sval);if(dd == null) dd = parseDateTime(sval);if (dd == null) {throw EvaluationException.invalidValue();}return dd.doubleValue();}throw new RuntimeException("Unexpected arg eval type (" + ev.getClass().getName() + ")");}
public ListSignalingChannelsResult listSignalingChannels(ListSignalingChannelsRequest request) {request = beforeClientExecution(request);return executeListSignalingChannels(request);}
public FieldQuery getFieldQuery( Query query ) {try {return getFieldQuery(query, null);} catch (IOException e) {throw new RuntimeException (e);}}
public DefineIndexFieldResult defineIndexField(DefineIndexFieldRequest request) {request = beforeClientExecution(request);return executeDefineIndexField(request);}
public synchronized StringBuffer insert(int index, char ch) {insert0(index, ch);return this;}
public StartFaceSearchResult startFaceSearch(StartFaceSearchRequest request) {request = beforeClientExecution(request);return executeStartFaceSearch(request);}
public SubmoduleAddCommand setProgressMonitor(ProgressMonitor monitor) {this.monitor = monitor;return this;}
public String toString() {return "IndexRevision version=" + version + " files=" + sourceFiles;}
public long getSize() {return delegate().getSize();}
public CreateRepoSyncTaskRequest() {super("cr", "2016-06-07", "CreateRepoSyncTask", "cr");setUriPattern("/repos/[RepoNamespace]/[RepoName]/syncTasks");setMethod(MethodType.PUT);}
public DefaultRowHeightRecord(RecordInputStream in) {field_1_option_flags = in.readShort();field_2_row_height   = in.readShort();}
public UpdateUserHierarchyResult updateUserHierarchy(UpdateUserHierarchyRequest request) {request = beforeClientExecution(request);return executeUpdateUserHierarchy(request);}
public static ByteBuffer wrap(byte[] array) {return new ReadWriteHeapByteBuffer(array);}
@Override public List<E> subList(int start, int end) {synchronized (mutex) {return new SynchronizedList<E>(list.subList(start, end), mutex);}}
public int getMidIx() {int ixDiff = _highIx - _lowIx;if(ixDiff < 2) {return -1;}return _lowIx + (ixDiff / 2);}
public PlainTextDictionary(InputStream dictFile) {in = new BufferedReader(IOUtils.getDecodingReader(dictFile, StandardCharsets.UTF_8));}
public DeleteBasePathMappingResult deleteBasePathMapping(DeleteBasePathMappingRequest request) {request = beforeClientExecution(request);return executeDeleteBasePathMapping(request);}
public DeleteSuppressedDestinationResult deleteSuppressedDestination(DeleteSuppressedDestinationRequest request) {request = beforeClientExecution(request);return executeDeleteSuppressedDestination(request);}
public DoubleValuesSource makeDistanceValueSource(Point queryPoint) {return makeDistanceValueSource(queryPoint, 1.0);}
public Object get(CharSequence key) {if (fst == null) {return null;}Arc<Long> arc = new Arc<>();Long result = null;try {result = lookupPrefix(new BytesRef(key), arc);} catch (IOException bogus) { throw new RuntimeException(bogus); }if (result == null || !arc.isFinal()) {return null;} else {return Integer.valueOf(decodeWeight(result + arc.nextFinalOutput()));}}
public String toString() {StringBuilder sb = new StringBuilder();sb.append("[OBJ]\n");for (final SubRecord record : subrecords) {sb.append("SUBRECORD: ").append(record);}sb.append("[/OBJ]\n");return sb.toString();}
public boolean stem() {limit_backward = cursor;cursor = limit;int v_1 = limit - cursor;r_endings();cursor = limit - v_1;int v_2 = limit - cursor;r_undouble();cursor = limit - v_2;int v_3 = limit - cursor;r_respell();cursor = limit - v_3;cursor = limit_backward;return true;}
public void serialize(LittleEndianOutput out) {out.writeShort(getIterations());}
public byte readByte(){return _in.readByte();}
public StringBuilder reverse() {reverse0();return this;}
public void reset() {seek(0);}
public final String getShortMessage() {byte[] raw = buffer;int msgB = RawParseUtils.tagMessage(raw, 0);if (msgB < 0) {return ""; }int msgE = RawParseUtils.endOfParagraph(raw, msgB);String str = RawParseUtils.decode(guessEncoding(), raw, msgB, msgE);if (RevCommit.hasLF(raw, msgB, msgE)) {str = StringUtils.replaceLineBreaksWithSpace(str);}return str;}
public void serialize(LittleEndianOutput out) {out.writeShort(field_1_precision);}
public ValueEval evaluate(ValueEval[] args, OperationEvaluationContext ec) { if (args.length < 2 || args.length > 3) {return ErrorEval.VALUE_INVALID;}int srcCellRow = ec.getRowIndex();int srcCellCol = ec.getColumnIndex();double start, end;double[] holidays;try {start = this.evaluator.evaluateDateArg(args[0], srcCellRow, srcCellCol);end = this.evaluator.evaluateDateArg(args[1], srcCellRow, srcCellCol);if (start > end) {return ErrorEval.NAME_INVALID;}ValueEval holidaysCell = args.length == 3 ? args[2] : null;holidays = this.evaluator.evaluateDatesArg(holidaysCell, srcCellRow, srcCellCol);return new NumberEval(WorkdayCalculator.instance.calculateWorkdays(start, end, holidays));} catch (EvaluationException e) {return ErrorEval.VALUE_INVALID;}}
public ListResolverRulesResult listResolverRules(ListResolverRulesRequest request) {request = beforeClientExecution(request);return executeListResolverRules(request);}
public IndexUpgrader(Directory dir, IndexWriterConfig iwc, boolean deletePriorCommits) {this.dir = dir;this.iwc = iwc;this.deletePriorCommits = deletePriorCommits;}
public ArrayRecord(RecordInputStream in) {super(in);_options = in.readUShort();_field3notUsed = in.readInt();int formulaTokenLen = in.readUShort();int totalFormulaLen = in.available();_formula = Formula.read(formulaTokenLen, in, totalFormulaLen);}
public GetPhoneNumberResult getPhoneNumber(GetPhoneNumberRequest request) {request = beforeClientExecution(request);return executeGetPhoneNumber(request);}
public boolean equals(Object obj) {if (obj == this) {return true;}else if (!(obj instanceof LexerTypeAction)) {return false;}return type == ((LexerTypeAction)obj).type;}
public Credential(String keyId, String secret, String securityToken) {this.accessKeyId = keyId;this.accessSecret = secret;this.securityToken = securityToken;this.refreshDate = new Date();}
public GetRelationalDatabaseLogStreamsResult getRelationalDatabaseLogStreams(GetRelationalDatabaseLogStreamsRequest request) {request = beforeClientExecution(request);return executeGetRelationalDatabaseLogStreams(request);}
public OpenNLPLemmatizerFilterFactory(Map<String,String> args) {super(args);dictionaryFile = get(args, DICTIONARY);lemmatizerModelFile = get(args, LEMMATIZER_MODEL);if (dictionaryFile == null && lemmatizerModelFile == null) {throw new IllegalArgumentException("Configuration Error: missing parameter: at least one of '"+ DICTIONARY + "' and '" + LEMMATIZER_MODEL + "' must be provided.");}if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameters: " + args);}}
public PutAutoScalingPolicyResult putAutoScalingPolicy(PutAutoScalingPolicyRequest request) {request = beforeClientExecution(request);return executePutAutoScalingPolicy(request);}
public void removeCompany() {remove1stProperty(PropertyIDMap.PID_COMPANY);}
public IndexOutput createOutput(String name, IOContext context) throws IOException {ensureOpen();if (context.context != Context.MERGE || context.mergeInfo.estimatedMergeBytes < minBytesDirect) {return delegate.createOutput(name, context);} else {return new NativeUnixIndexOutput(getDirectory().resolve(name), name, mergeBufferSize);}}
public GetExternalModelsResult getExternalModels(GetExternalModelsRequest request) {request = beforeClientExecution(request);return executeGetExternalModels(request);}
public StartStreamEncryptionResult startStreamEncryption(StartStreamEncryptionRequest request) {request = beforeClientExecution(request);return executeStartStreamEncryption(request);}
public String getInflectionType(int wordId) {return null; }
public CloseIgnoringInputStream(InputStream in) {super(in);}
public DeleteDeploymentResult deleteDeployment(DeleteDeploymentRequest request) {request = beforeClientExecution(request);return executeDeleteDeployment(request);}
public PutRuleResult putRule(PutRuleRequest request) {request = beforeClientExecution(request);return executePutRule(request);}
public StartLifecyclePolicyPreviewResult startLifecyclePolicyPreview(StartLifecyclePolicyPreviewRequest request) {request = beforeClientExecution(request);return executeStartLifecyclePolicyPreview(request);}
public void setBigFileThreshold(int bigFileThreshold) {this.bigFileThreshold = bigFileThreshold;}
public CreateBatchInferenceJobResult createBatchInferenceJob(CreateBatchInferenceJobRequest request) {request = beforeClientExecution(request);return executeCreateBatchInferenceJob(request);}
public PendingTaskCount countPendingDecisionTasks(CountPendingDecisionTasksRequest request) {request = beforeClientExecution(request);return executeCountPendingDecisionTasks(request);}
public Instance(String instanceId) {setInstanceId(instanceId);}
public Pair<String,String> splitExtensionField(String defaultField,String field) {int indexOf = field.indexOf(this.extensionFieldDelimiter);if (indexOf < 0)return new Pair<>(field, null);final String indexField = indexOf == 0 ? defaultField : field.substring(0,indexOf);final String extensionKey = field.substring(indexOf + 1);return new Pair<>(indexField, extensionKey);}
public String getText(Token start, Token stop) {if ( start!=null && stop!=null ) {return getText(Interval.of(start.getTokenIndex(), stop.getTokenIndex()));}return "";}
public void setPackedGitOpenFiles(int fdLimit) {packedGitOpenFiles = fdLimit;}
public final ValueEval getAbsoluteValue(int row, int col) {int rowOffsetIx = row - _firstRow;int colOffsetIx = col - _firstColumn;if(rowOffsetIx < 0 || rowOffsetIx >= _nRows) {throw new IllegalArgumentException("Specified row index (" + row+ ") is outside the allowed range (" + _firstRow + ".." + _lastRow + ")");}if(colOffsetIx < 0 || colOffsetIx >= _nColumns) {throw new IllegalArgumentException("Specified column index (" + col+ ") is outside the allowed range (" + _firstColumn + ".." + col + ")");}return getRelativeValue(rowOffsetIx, colOffsetIx);}
public BatchRefUpdate disableRefLog() {refLogMessage = null;refLogIncludeResult = false;return this;}
public boolean equals(Object other) {if (!(other instanceof DoubleBuffer)) {return false;}DoubleBuffer otherBuffer = (DoubleBuffer) other;if (remaining() != otherBuffer.remaining()) {return false;}int myPosition = position;int otherPosition = otherBuffer.position;boolean equalSoFar = true;while (equalSoFar && (myPosition < limit)) {double a = get(myPosition++);double b = otherBuffer.get(otherPosition++);equalSoFar = a == b || (a != a && b != b);}return equalSoFar;}
public long seek(long ord) {throw new UnsupportedOperationException();}
public TerminateJobFlowsRequest(java.util.List<String> jobFlowIds) {setJobFlowIds(jobFlowIds);}
@Override public boolean equals(Object other) {if (other instanceof CopyOnWriteArrayList) {return this == other|| Arrays.equals(elements, ((CopyOnWriteArrayList<?>) other).elements);} else if (other instanceof List) {Object[] snapshot = elements;Iterator<?> i = ((List<?>) other).iterator();for (Object o : snapshot) {if (!i.hasNext() || !Objects.equal(o, i.next())) {return false;}}return !i.hasNext();} else {return false;}}
public CreateAppResult createApp(CreateAppRequest request) {request = beforeClientExecution(request);return executeCreateApp(request);}
public CreateClientVpnRouteResult createClientVpnRoute(CreateClientVpnRouteRequest request) {request = beforeClientExecution(request);return executeCreateClientVpnRoute(request);}
public PackedObjectInfo getObject(int nth) {return entries[nth];}
public GenerateClientCertificateResult generateClientCertificate(GenerateClientCertificateRequest request) {request = beforeClientExecution(request);return executeGenerateClientCertificate(request);}
public GetHostedZoneCountResult getHostedZoneCount() {return getHostedZoneCount(new GetHostedZoneCountRequest());}
public boolean isTraverseEmptyCells() {return traverseEmptyCells;}
public int getCachedResultType() {if (specialCachedValue == null) {return CellType.NUMERIC.getCode();}return specialCachedValue.getValueType();}
public void removeSubject() {remove1stProperty(PropertyIDMap.PID_SUBJECT);}
public ValueEval evaluate(int srcRowIndex, int srcColumnIndex, ValueEval arg0, ValueEval arg1) {ValueEval ve0;ValueEval ve1;try {ve0 = OperandResolver.getSingleValue(arg0, srcRowIndex, srcColumnIndex);ve1 = OperandResolver.getSingleValue(arg1, srcRowIndex, srcColumnIndex);} catch (EvaluationException e) {return e.getErrorEval();}StringBuilder sb = new StringBuilder();sb.append(getText(ve0));sb.append(getText(ve1));return new StringEval(sb.toString());}
public StaticCredentialsProvider(IClientProfile clientProfile) {IClientProfile clientProfile1 = clientProfile;Credential legacyCredential = clientProfile1.getCredential();if (null != legacyCredential.getSecurityToken()) {this.credentials = new BasicSessionCredentials(legacyCredential.getAccessKeyId(), legacyCredential.getAccessSecret(), legacyCredential.getSecurityToken());} else {this.credentials = new LegacyCredentials(legacyCredential);}}
public static float[] grow(float[] array, int minSize) {assert minSize >= 0: "size must be positive (got " + minSize + "): likely integer overflow?";if (array.length < minSize) {float[] copy = new float[oversize(minSize, Float.BYTES)];System.arraycopy(array, 0, copy, 0, array.length);return copy;} elsereturn array;}
public StoredField(String name, double value) {super(name, TYPE);fieldsData = value;}
public LazyAreaEval getColumn(int columnIndex) {if (columnIndex >= getWidth()) {throw new IllegalArgumentException("Invalid columnIndex " + columnIndex+ ".  Allowable range is (0.." + getWidth() + ").");}int absColIx = getFirstColumn() + columnIndex;return new LazyAreaEval(getFirstRow(), absColIx, getLastRow(), absColIx, _evaluator);}
public RowRecord getRow(int rowIndex) {int maxrow = SpreadsheetVersion.EXCEL97.getLastRowIndex();if (rowIndex < 0 || rowIndex > maxrow) {throw new IllegalArgumentException("The row number must be between 0 and " + maxrow + ", but had: " + rowIndex);}return _rowRecords.get(Integer.valueOf(rowIndex));}
public DescribeSecurityGroupsResult describeSecurityGroups(DescribeSecurityGroupsRequest request) {request = beforeClientExecution(request);return executeDescribeSecurityGroups(request);}
public ANTLRInputStream(String input) {this.data = input.toCharArray();this.n = input.length();}
public Iterator<E> descendingIterator() {return new ReverseLinkIterator<E>(this);}
public DescribeIdentityResult describeIdentity(DescribeIdentityRequest request) {request = beforeClientExecution(request);return executeDescribeIdentity(request);}
public DescribeReceiptRuleResult describeReceiptRule(DescribeReceiptRuleRequest request) {request = beforeClientExecution(request);return executeDescribeReceiptRule(request);}
public DeleteTransitGatewayPeeringAttachmentResult deleteTransitGatewayPeeringAttachment(DeleteTransitGatewayPeeringAttachmentRequest request) {request = beforeClientExecution(request);return executeDeleteTransitGatewayPeeringAttachment(request);}
public static double log2(double x) {return Math.log(x) / LOG_2;}
public String toString(){StringBuilder buffer = new StringBuilder();buffer.append("[AREA]\n");buffer.append("    .formatFlags          = ").append("0x").append(HexDump.toHex(  getFormatFlags ())).append(" (").append( getFormatFlags() ).append(" )");buffer.append(System.getProperty("line.separator"));buffer.append("         .stacked                  = ").append(isStacked()).append('\n');buffer.append("         .displayAsPercentage      = ").append(isDisplayAsPercentage()).append('\n');buffer.append("         .shadow                   = ").append(isShadow()).append('\n');buffer.append("[/AREA]\n");return buffer.toString();}
public static int getSingleViableAlt(Collection<BitSet> altsets) {BitSet viableAlts = new BitSet();for (BitSet alts : altsets) {int minAlt = alts.nextSetBit(0);viableAlts.set(minAlt);if ( viableAlts.cardinality()>1 ) { return ATN.INVALID_ALT_NUMBER;}}return viableAlts.nextSetBit(0);}
public GetCampaignDateRangeKpiResult getCampaignDateRangeKpi(GetCampaignDateRangeKpiRequest request) {request = beforeClientExecution(request);return executeGetCampaignDateRangeKpi(request);}
public GetVoiceConnectorTerminationResult getVoiceConnectorTermination(GetVoiceConnectorTerminationRequest request) {request = beforeClientExecution(request);return executeGetVoiceConnectorTermination(request);}
public LockFailedException(File file, String message) {super(message);this.file = file;}
public void getChars(int start, int end, char[] dst, int dstStart) {if (start > count || end > count || start > end) {throw startEndAndLength(start, end);}System.arraycopy(value, start, dst, dstStart, end - start);}
public int set(int index, long[] arr, int off, int len) {assert len > 0 : "len must be > 0 (got " + len + ")";assert index >= 0 && index < size();len = Math.min(len, size() - index);assert off + len <= arr.length;for (int i = index, o = off, end = index + len; i < end; ++i, ++o) {set(i, arr[o]);}return len;}
public DeleteRouteResult deleteRoute(DeleteRouteRequest request) {request = beforeClientExecution(request);return executeDeleteRoute(request);}
public boolean remove(Object o) {return ConcurrentHashMap.this.remove(o) != null;}
public SendMessageBatchResult sendMessageBatch(SendMessageBatchRequest request) {request = beforeClientExecution(request);return executeSendMessageBatch(request);}
public static ByteBuffer wrap(byte[] array, int start, int byteCount) {Arrays.checkOffsetAndCount(array.length, start, byteCount);ByteBuffer buf = new ReadWriteHeapByteBuffer(array);buf.position = start;buf.limit = start + byteCount;return buf;}
public TextProgressMonitor(Writer out) {this.out = out;this.write = true;}
@Override public Iterator<K> iterator() {final Iterator<Entry<K, V>> iterator = filteredEntrySet.iterator();return new UnmodifiableIterator<K>() {
public int getRenameScore() {return outCandidate.renameScore;}
public static void advise(FileDescriptor fd, long offset, long len, int advise) throws IOException {final int code = posix_fadvise(fd, offset, len, advise);if (code != 0) {throw new RuntimeException("posix_fadvise failed code=" + code);}}
public DeleteCloudFrontOriginAccessIdentityResult deleteCloudFrontOriginAccessIdentity(DeleteCloudFrontOriginAccessIdentityRequest request) {request = beforeClientExecution(request);return executeDeleteCloudFrontOriginAccessIdentity(request);}
public static TermRangeQuery newStringRange(String field, String lowerTerm, String upperTerm, boolean includeLower, boolean includeUpper) {BytesRef lower = lowerTerm == null ? null : new BytesRef(lowerTerm);BytesRef upper = upperTerm == null ? null : new BytesRef(upperTerm);return new TermRangeQuery(field, lower, upper, includeLower, includeUpper);}
public DeleteCacheSecurityGroupRequest(String cacheSecurityGroupName) {setCacheSecurityGroupName(cacheSecurityGroupName);}
public GetSdkTypeResult getSdkType(GetSdkTypeRequest request) {request = beforeClientExecution(request);return executeGetSdkType(request);}
public boolean evaluate(int cmpResult) {switch (_code) {case NONE:case EQ:return cmpResult == 0;case NE: return cmpResult != 0;case LT: return cmpResult <  0;case LE: return cmpResult <= 0;case GT: return cmpResult >  0;case GE: return cmpResult >= 0;}throw new RuntimeException("Cannot call boolean evaluate on non-equality operator '"+ _representation + "'");}
public String toString() {if ( isEmpty() ) return "[]";StringBuilder buf = new StringBuilder();buf.append("[");for (int i=0; i<returnStates.length; i++) {if ( i>0 ) buf.append(", ");if ( returnStates[i]==EMPTY_RETURN_STATE ) {buf.append("$");continue;}buf.append(returnStates[i]);if ( parents[i]!=null ) {buf.append(' ');buf.append(parents[i].toString());}else {buf.append("null");}}buf.append("]");return buf.toString();}
public SendRawEmailRequest(RawMessage rawMessage) {setRawMessage(rawMessage);}
public AddApplicationReferenceDataSourceResult addApplicationReferenceDataSource(AddApplicationReferenceDataSourceRequest request) {request = beforeClientExecution(request);return executeAddApplicationReferenceDataSource(request);}
public GetRecommenderConfigurationsResult getRecommenderConfigurations(GetRecommenderConfigurationsRequest request) {request = beforeClientExecution(request);return executeGetRecommenderConfigurations(request);}
public synchronized int available() {return count - pos;}
public boolean equals(ATNConfig other) {if (this == other) {return true;}else if (other == null) {return false;}return this.state.stateNumber==other.state.stateNumber&& this.alt==other.alt&& (this.context==other.context || (this.context != null && this.context.equals(other.context)))&& this.semanticContext.equals(other.semanticContext)&& this.isPrecedenceFilterSuppressed() == other.isPrecedenceFilterSuppressed();}
public GetTrafficPolicyResult getTrafficPolicy(GetTrafficPolicyRequest request) {request = beforeClientExecution(request);return executeGetTrafficPolicy(request);}
public DescribeSubscribedWorkteamResult describeSubscribedWorkteam(DescribeSubscribedWorkteamRequest request) {request = beforeClientExecution(request);return executeDescribeSubscribedWorkteam(request);}
public Snapshot createSnapshot(CreateSnapshotRequest request) {request = beforeClientExecution(request);return executeCreateSnapshot(request);}
public int getPasswordVerifier() {return passwordVerifier;}
public int getIndexOfName(String name) {for (int i = 0; i < _externalNameRecords.length; i++) {if (_externalNameRecords[i].getText().equalsIgnoreCase(name)) {return i;}}return -1;}
public DescribePartnerEventSourceResult describePartnerEventSource(DescribePartnerEventSourceRequest request) {request = beforeClientExecution(request);return executeDescribePartnerEventSource(request);}
public void write(String str, int offset, int count) {String sub = str.substring(offset, offset + count);buf.append(sub);}
public void writeLong(long value) throws IOException {checkWritePrimitiveTypes();primitiveTypes.writeLong(value);}
@Override public int compare(T o1, T o2) {return cmp.compare(o2, o1);}
public JapaneseKatakanaStemFilter(TokenStream input, int minimumLength) {super(input);this.minimumKatakanaLength = minimumLength;}
public int getEntryPathHashCode() {int hash = 0;for (int i = Math.max(0, pathLen - 16); i < pathLen; i++) {byte c = path[i];if (c != ' ')hash = (hash >>> 2) + (c << 24);}return hash;}
public void add(String key, ParserExtension extension) {this.extensions.put(key, extension);}
public RefSubRecord(int extBookIndex, int firstSheetIndex, int lastSheetIndex) {_extBookIndex = extBookIndex;_firstSheetIndex = firstSheetIndex;_lastSheetIndex = lastSheetIndex;}
public static ValueVector createVector(RefEval re) {return new SheetVector(re);}
public String toString() {return "AnyObjectId[" + name() + "]";}
public SaveTaskForSubmittingDomainRealNameVerificationByIdentityCredentialRequest() {super("Domain", "2018-01-29", "SaveTaskForSubmittingDomainRealNameVerificationByIdentityCredential");setMethod(MethodType.POST);}
public final IntBuffer asIntBuffer() {return IntToByteBufferAdapter.asIntBuffer(this);}
public MissingObjectException(ObjectId id, String type) {super(MessageFormat.format(JGitText.get().missingObject, type, id.name()));missing = id.copy();}
public static Class<? extends TokenFilterFactory> lookupClass(String name) {return loader.lookupClass(name);}
public String quote(String in) {if (in.matches("^~[A-Za-z0-9_-]+$")) { return in + "/"; }.*$")) { final int i = in.indexOf('/') + 1;if (i == in.length())return in;return in.substring(0, i) + super.quote(in.substring(i));}return super.quote(in);}
public static int finish(int hash, int numberOfWords) {hash = hash ^ (numberOfWords * 4);hash = hash ^ (hash >>> 16);hash = hash * 0x85EBCA6B;hash = hash ^ (hash >>> 13);hash = hash * 0xC2B2AE35;hash = hash ^ (hash >>> 16);return hash;}
public void unsafeWrite(char b) {buf[len++] = b;}
public int set(int index, long[] arr, int off, int len) {long max = 0;for (int i = off, end = off + len; i < end; ++i) {max |= arr[i];}ensureCapacity(max);return current.set(index, arr, off, len);}
public void clear() {Iterator<E> it = iterator();while (it.hasNext()) {it.next();it.remove();}}
public DirCache call() throws GitAPIException,NoFilepatternException {if (filepatterns.isEmpty())throw new NoFilepatternException(JGitText.get().atLeastOnePatternIsRequired);checkCallable();DirCache dc = null;List<String> actuallyDeletedFiles = new ArrayList<>();try (TreeWalk tw = new TreeWalk(repo)) {dc = repo.lockDirCache();DirCacheBuilder builder = dc.builder();tw.reset(); tw.setRecursive(true);tw.setFilter(PathFilterGroup.createFromStrings(filepatterns));tw.addTree(new DirCacheBuildIterator(builder));while (tw.next()) {if (!cached) {final FileMode mode = tw.getFileMode(0);if (mode.getObjectType() == Constants.OBJ_BLOB) {String relativePath = tw.getPathString();final File path = new File(repo.getWorkTree(),relativePath);if (delete(path)) {actuallyDeletedFiles.add(relativePath);}}}}builder.commit();setCallable(false);} catch (IOException e) {throw new JGitInternalException(JGitText.get().exceptionCaughtDuringExecutionOfRmCommand, e);} finally {try {if (dc != null) {dc.unlock();}} finally {if (!actuallyDeletedFiles.isEmpty()) {repo.fireEvent(new WorkingTreeModifiedEvent(null,actuallyDeletedFiles));}}}return dc;}
public void setCurrent(char text[], int length) {current = text;cursor = 0;limit = length;limit_backward = 0;bra = cursor;ket = limit;}
public PersianNormalizationFilter(TokenStream input) {super(input);}
public ShortBuffer put(short c) {if (position == limit) {throw new BufferOverflowException();}backingArray[offset + position++] = c;return this;}
public LexerActionExecutor(LexerAction[] lexerActions) {this.lexerActions = lexerActions;int hash = MurmurHash.initialize();for (LexerAction lexerAction : lexerActions) {hash = MurmurHash.update(hash, lexerAction);}this.hashCode = MurmurHash.finish(hash, lexerActions.length);}
public boolean equals( Object o ) {return o instanceof SwedishStemmer;}
public static double getExcelDate(Date date, boolean use1904windowing) {Calendar calStart = LocaleUtil.getLocaleCalendar();calStart.setTime(date);int year = calStart.get(Calendar.YEAR);int dayOfYear = calStart.get(Calendar.DAY_OF_YEAR);int hour = calStart.get(Calendar.HOUR_OF_DAY);int minute = calStart.get(Calendar.MINUTE);int second = calStart.get(Calendar.SECOND);int milliSecond = calStart.get(Calendar.MILLISECOND);return internalGetExcelDate(year, dayOfYear, hour, minute, second, milliSecond, use1904windowing);}
public RightMarginRecord( RecordInputStream in ) {field_1_margin = in.readDouble();}
public DeleteAttributesResult deleteAttributes(DeleteAttributesRequest request) {request = beforeClientExecution(request);return executeDeleteAttributes(request);}
public GlobalReplicationGroup decreaseNodeGroupsInGlobalReplicationGroup(DecreaseNodeGroupsInGlobalReplicationGroupRequest request) {request = beforeClientExecution(request);return executeDecreaseNodeGroupsInGlobalReplicationGroup(request);}
public ModifyVpcEndpointConnectionNotificationResult modifyVpcEndpointConnectionNotification(ModifyVpcEndpointConnectionNotificationRequest request) {request = beforeClientExecution(request);return executeModifyVpcEndpointConnectionNotification(request);}
public RegisterStreamConsumerResult registerStreamConsumer(RegisterStreamConsumerRequest request) {request = beforeClientExecution(request);return executeRegisterStreamConsumer(request);}
public void build(InputIterator iterator) throws IOException {if (iterator.hasPayloads()) {throw new IllegalArgumentException("this suggester doesn't support payloads");}if (iterator.hasContexts()) {throw new IllegalArgumentException("this suggester doesn't support contexts");}count = 0;trie = new JaspellTernarySearchTrie();trie.setMatchAlmostDiff(editDistance);BytesRef spare;final CharsRefBuilder charsSpare = new CharsRefBuilder();while ((spare = iterator.next()) != null) {final long weight = iterator.weight();if (spare.length == 0) {continue;}charsSpare.copyUTF8Bytes(spare);trie.put(charsSpare.toString(), Long.valueOf(weight));count++;}}
public DescribeStorageResult describeStorage(DescribeStorageRequest request) {request = beforeClientExecution(request);return executeDescribeStorage(request);}
public ShortBuffer get(short[] dst) {return get(dst, 0, dst.length);}
public K firstKey() {Entry<K, V> entry = endpoint(true);if (entry == null) {throw new NoSuchElementException();}return entry.getKey();}
public PipedReader(PipedWriter out) throws IOException {connect(out);}
public void startFragment(TextFragment newFragment) {uniqueTermsInFragment = new HashSet<>();currentTextFragment = newFragment;totalScore = 0;}
public E remove(int index) {synchronized (mutex) {return delegate().remove(index);}}
public DescribeLaunchConfigurationsResult describeLaunchConfigurations() {return describeLaunchConfigurations(new DescribeLaunchConfigurationsRequest());}
public CancelClusterResult cancelCluster(CancelClusterRequest request) {request = beforeClientExecution(request);return executeCancelCluster(request);}
public static char[] grow(char[] array) {return grow(array, 1 + array.length);}
public AddNoteCommand notesAdd() {return new AddNoteCommand(repo);}
public CountryRecord(RecordInputStream in) {field_1_default_country = in.readShort();field_2_current_country = in.readShort();}
public static int getRecordSizeForBlockCount(int blockCount) {return 20 + 4 * blockCount;}
public CreatePrivateVirtualInterfaceResult createPrivateVirtualInterface(CreatePrivateVirtualInterfaceRequest request) {request = beforeClientExecution(request);return executeCreatePrivateVirtualInterface(request);}
public DescribeConversionTasksResult describeConversionTasks() {return describeConversionTasks(new DescribeConversionTasksRequest());}
public TreeFilter clone() {return new Binary(a.clone(), b.clone());}
public String getDataFormatString() {if (getDataFormatStringCache.get() != null) {if (lastDateFormat.get() == getDataFormat() && _workbook.getFormats().equals(lastFormats.get())) {return getDataFormatStringCache.get();}}lastFormats.set(_workbook.getFormats());lastDateFormat.set(getDataFormat());getDataFormatStringCache.set(getDataFormatString(_workbook));return getDataFormatStringCache.get();}
public synchronized int codePointBefore(int index) {return super.codePointBefore(index);}
public void stopWalk() {if (parent != null)parent.stopWalk();}
public synchronized E remove(int index) {@SuppressWarnings("unchecked")E removed = (E) elements[index];removeRange(index, index + 1);return removed;}
public int getExternalSheetIndex(String sheetName) {int sheetIndex = _uBook.getSheetIndex(sheetName);return _iBook.checkExternSheet(sheetIndex);}
public CalcCountRecord(RecordInputStream in) {field_1_iterations = in.readShort();}
public RejectInvitationResult rejectInvitation(RejectInvitationRequest request) {request = beforeClientExecution(request);return executeRejectInvitation(request);}
public int valueAt(int index) {return mValues[index];}
public ListVoiceConnectorsResult listVoiceConnectors(ListVoiceConnectorsRequest request) {request = beforeClientExecution(request);return executeListVoiceConnectors(request);}
public ClientException(String message) {super(message);this.setErrorType(ErrorType.Client);}
public StringBuilder append(float f) {RealToString.getInstance().appendFloat(this, f);return this;}
public static Element getFirstChildElement(Element element) {for (Node kid = element.getFirstChild(); kid != null; kid = kid.getNextSibling()) {if (kid.getNodeType() == Node.ELEMENT_NODE) {return (Element) kid;}}return null;}
public void setHideObj(short hide){field_1_hide_obj = hide;}
public GetTrafficPolicyInstanceCountResult getTrafficPolicyInstanceCount(GetTrafficPolicyInstanceCountRequest request) {request = beforeClientExecution(request);return executeGetTrafficPolicyInstanceCount(request);}
public int getDepth() {return depth;}
public TreeFilter negate() {return NotTreeFilter.create(this);}
public CreateInvalidationResult createInvalidation(CreateInvalidationRequest request) {request = beforeClientExecution(request);return executeCreateInvalidation(request);}
public ListGroupsResult listGroups(ListGroupsRequest request) {request = beforeClientExecution(request);return executeListGroups(request);}
public void endTask() {if (!isMainThread())throw new IllegalStateException();pm.endTask();}
public UpdateProfilingGroupResult updateProfilingGroup(UpdateProfilingGroupRequest request) {request = beforeClientExecution(request);return executeUpdateProfilingGroup(request);}
public AddInstanceGroupsResult addInstanceGroups(AddInstanceGroupsRequest request) {request = beforeClientExecution(request);return executeAddInstanceGroups(request);}
public AssociateResolverRuleResult associateResolverRule(AssociateResolverRuleRequest request) {request = beforeClientExecution(request);return executeAssociateResolverRule(request);}
public DescribeCacheParametersResult describeCacheParameters(DescribeCacheParametersRequest request) {request = beforeClientExecution(request);return executeDescribeCacheParameters(request);}
public PutMethodResponseResult putMethodResponse(PutMethodResponseRequest request) {request = beforeClientExecution(request);return executePutMethodResponse(request);}
public FunctionQuery(ValueSource func) {this.func=func;}
public AnalyticsPrefixPredicate(String prefix) {this.prefix = prefix;}
public void setColor(short byteIndex, byte red, byte green, byte blue){int i = byteIndex - FIRST_COLOR_INDEX;if (i < 0 || i >= STANDARD_PALETTE_SIZE){return;}while (_colors.size() <= i) {_colors.add(new PColor(0, 0, 0));}PColor custColor = new PColor(red, green, blue);_colors.set(i, custColor);}
public final IntBuffer put(int[] src, int srcOffset, int intCount) {throw new ReadOnlyBufferException();}
public EventSubscription addSourceIdentifierToSubscription(AddSourceIdentifierToSubscriptionRequest request) {request = beforeClientExecution(request);return executeAddSourceIdentifierToSubscription(request);}
public FileIdCluster( int drawingGroupId, int numShapeIdsUsed ) {this.field_1_drawingGroupId = drawingGroupId;this.field_2_numShapeIdsUsed = numShapeIdsUsed;}
public DeleteMessageBatchRequestEntry(String id, String receiptHandle) {setId(id);setReceiptHandle(receiptHandle);}
public BinaryDocValuesField(String name, BytesRef value) {super(name, TYPE);fieldsData = value;}
public static FuncVarPtg create(String pName, int numArgs) {return create(numArgs, lookupIndex(pName));}
public DescribeOrganizationConfigurationResult describeOrganizationConfiguration(DescribeOrganizationConfigurationRequest request) {request = beforeClientExecution(request);return executeDescribeOrganizationConfiguration(request);}
public boolean equals(Object o) {if (!(o instanceof ATNConfig)) {return false;}return this.equals((ATNConfig)o);}
public PipedInputStream(PipedOutputStream out) throws IOException {connect(out);}
public boolean isMatch() {if (heads.isEmpty())return false;final ListIterator<Head> headIterator = heads.listIterator(heads.size());while (headIterator.hasPrevious()) {final Head head = headIterator.previous();if (head == LastHead.INSTANCE) {return true;}}return false;}
public SignalResourceResult signalResource(SignalResourceRequest request) {request = beforeClientExecution(request);return executeSignalResource(request);}
public String toString() {return "<matchNoDocsQueryNode/>";}
public void serialize(LittleEndianOutput out) {out.writeInt(field_1_row_offset);for (short field_2_cell_offset : field_2_cell_offsets) {out.writeShort(field_2_cell_offset);}}
public PositionSpan(int start, int end) {this.start = start;this.end = end;}
public BuildSuggestersResult buildSuggesters(BuildSuggestersRequest request) {request = beforeClientExecution(request);return executeBuildSuggesters(request);}
public void mark(int markLimit) throws IOException {if (markLimit < 0) {throw new IllegalArgumentException();}synchronized (lock) {checkNotClosed();this.markLimit = markLimit;mark = pos;}}
public BytesRef next() {termOrd++;if (termOrd < terms.length) {return setTerm();} else {return null;}}
public String toStringTree() {return toString();}
public GetBasePathMappingResult getBasePathMapping(GetBasePathMappingRequest request) {request = beforeClientExecution(request);return executeGetBasePathMapping(request);}
public void abort() {try {reset();} finally {if (nextTermsHash != null) {nextTermsHash.abort();}}}
public String toFormulaString(String[] operands) {StringBuilder buffer = new StringBuilder();buffer.append(ADD);buffer.append(operands[ 0]);return buffer.toString();}
public String[] listAll() throws IOException {List<String> files = new ArrayList<>();NoSuchFileException exc = null;try {for(String f : primaryDir.listAll()) {String ext = getExtension(f);if (primaryExtensions.contains(ext)) {files.add(f);}}} catch (NoSuchFileException e) {exc = e;}try {for(String f : secondaryDir.listAll()) {String ext = getExtension(f);if (primaryExtensions.contains(ext) == false) {files.add(f);}}} catch (NoSuchFileException e) {if (exc != null) {throw exc;}if (files.isEmpty()) {throw e;}}if (exc != null && files.isEmpty()) {throw exc;}String[] result = files.toArray(new String[files.size()]);Arrays.sort(result);return result;}
public RegisterDBProxyTargetsResult registerDBProxyTargets(RegisterDBProxyTargetsRequest request) {request = beforeClientExecution(request);return executeRegisterDBProxyTargets(request);}
public String toFormulaString() {return "UNKNOWN";}
public Token get(int i) {if ( i < 0 || i >= tokens.size() ) {throw new IndexOutOfBoundsException("token index "+i+" out of range 0.."+(tokens.size()-1));}return tokens.get(i);}
public CreateUsageReportSubscriptionResult createUsageReportSubscription(CreateUsageReportSubscriptionRequest request) {request = beforeClientExecution(request);return executeCreateUsageReportSubscription(request);}
public int [] toArray(){int[] rval = new int[ _limit ];System.arraycopy(_array, 0, rval, 0, _limit);return rval;}
public EnableEnhancedMonitoringResult enableEnhancedMonitoring(EnableEnhancedMonitoringRequest request) {request = beforeClientExecution(request);return executeEnableEnhancedMonitoring(request);}
public UpdateContactAttributesResult updateContactAttributes(UpdateContactAttributesRequest request) {request = beforeClientExecution(request);return executeUpdateContactAttributes(request);}
public SimpleImmutableEntry(K theKey, V theValue) {key = theKey;value = theValue;}
public CacheCluster createCacheCluster(CreateCacheClusterRequest request) {request = beforeClientExecution(request);return executeCreateCacheCluster(request);}
public final ValueEval evaluate(int srcRowIndex, int srcColumnIndex, ValueEval arg0) {double val;try {ValueEval ve = OperandResolver.getSingleValue(arg0, srcRowIndex, srcColumnIndex);val = OperandResolver.coerceValueToDouble(ve);} catch (EvaluationException e) {return e.getErrorEval();}if (val < 0) {return ErrorEval.NUM_ERROR;}return new NumberEval(getCalField(val));}
public boolean matches(ParseTree tree) {return matcher.match(tree, this).succeeded();}
public long next() throws IOException {current = fstEnum.next();if (current == null) {return -1;} else {return current.output;}}
public void notifyUpdatedBlankCell(BookSheetKey bsk, int rowIndex, int columnIndex, IEvaluationListener evaluationListener) {if (_usedBlankCellGroup != null) {if (_usedBlankCellGroup.containsCell(bsk, rowIndex, columnIndex)) {clearFormulaEntry();recurseClearCachedFormulaResults(evaluationListener);}}}
public void add(int el) {if ( readonly ) throw new IllegalStateException("can't alter readonly IntervalSet");add(el,el);}
public int stem(final char s[], int len) {if (len < 4) return len;if (len > 5 && endsWith(s, len, "ища"))return len - 3;len = removeArticle(s, len);len = removePlural(s, len);if (len > 3) {if (endsWith(s, len, "я"))len--;if (endsWith(s, len, "а") ||endsWith(s, len, "о") ||endsWith(s, len, "е"))len--;}if (len > 4 && endsWith(s, len, "ен")) {s[len - 2] = 'н'; len--;}if (len > 5 && s[len - 2] == 'ъ') {s[len - 2] = s[len - 1]; len--;}return len;}
public BatchGetVariableResult batchGetVariable(BatchGetVariableRequest request) {request = beforeClientExecution(request);return executeBatchGetVariable(request);}
public ValueEval getItem(int index) {if(index > _size) {throw new ArrayIndexOutOfBoundsException("Specified index (" + index+ ") is outside the allowed range (0.." + (_size-1) + ")");}return _tableArray.getValue(index, _columnIndex);}
public static final int encoding(byte[] b, int ptr) {final int sz = b.length;while (ptr < sz) {if (b[ptr] == '\n')return -1;if (b[ptr] == 'e')break;ptr = nextLF(b, ptr);}return match(b, ptr, encoding);}
public synchronized StringBuffer insert(int index, char[] chars, int start, int length) {insert0(index, chars, start, length);return this;}
public SummaryInformation(final PropertySet ps) throws UnexpectedPropertySetTypeException {super(ps);if (!isSummaryInformation()) {throw new UnexpectedPropertySetTypeException("Not a " + getClass().getName());}}
public int get(int key, int valueIfKeyNotFound) {int i = binarySearch(mKeys, 0, mSize, key);if (i < 0) {return valueIfKeyNotFound;} else {return mValues[i];}}
public ReplaceIamInstanceProfileAssociationResult replaceIamInstanceProfileAssociation(ReplaceIamInstanceProfileAssociationRequest request) {request = beforeClientExecution(request);return executeReplaceIamInstanceProfileAssociation(request);}
public boolean include(RevWalk walker, RevCommit c) {return false;}
public void print(float f) {print(String.valueOf(f));}
public void removeName(int namenum) {_definedNames.remove(namenum);}
public ET next() {if (expectedModCount == list.modCount) {if (hasNext()) {link = link.previous;canRemove = true;return link.data;}throw new NoSuchElementException();}throw new ConcurrentModificationException();}
public CacheCluster rebootCacheCluster(RebootCacheClusterRequest request) {request = beforeClientExecution(request);return executeRebootCacheCluster(request);}
public void registerActivityType(RegisterActivityTypeRequest request) {request = beforeClientExecution(request);executeRegisterActivityType(request);}
public TranslateTextResult translateText(TranslateTextRequest request) {request = beforeClientExecution(request);return executeTranslateText(request);}
public String getFetchedFrom() {return this.fetchedFrom;}
public void respondActivityTaskFailed(RespondActivityTaskFailedRequest request) {request = beforeClientExecution(request);executeRespondActivityTaskFailed(request);}
public MultiCategoryListsFacetsExample() {config.setIndexFieldName("Author", "author");config.setIndexFieldName("Publish Date", "pubdate");config.setHierarchical("Publish Date", true);}
public SeriesRecord getSeries() {return series;}
public LongBuffer put(int index, long c) {throw new ReadOnlyBufferException();}
public CreateLogPatternResult createLogPattern(CreateLogPatternRequest request) {request = beforeClientExecution(request);return executeCreateLogPattern(request);}
public ResetCacheParameterGroupResult resetCacheParameterGroup(ResetCacheParameterGroupRequest request) {request = beforeClientExecution(request);return executeResetCacheParameterGroup(request);}
public static String getBuiltinFormat(int index) {if (index < 0 || index >=_formats.length) {return null;}return _formats[index];}
public DescribeNotebookInstanceResult describeNotebookInstance(DescribeNotebookInstanceRequest request) {request = beforeClientExecution(request);return executeDescribeNotebookInstance(request);}
public DBClusterParameterGroup copyDBClusterParameterGroup(CopyDBClusterParameterGroupRequest request) {request = beforeClientExecution(request);return executeCopyDBClusterParameterGroup(request);}
public ListDeviceEventsResult listDeviceEvents(ListDeviceEventsRequest request) {request = beforeClientExecution(request);return executeListDeviceEvents(request);}
public static SupBookRecord createExternalReferences(String url, String[] sheetNames) {return new SupBookRecord(url, sheetNames);}
public JapaneseReadingFormFilter(TokenStream input, boolean useRomaji) {super(input);this.useRomaji = useRomaji;}
public GetInvalidationRequest(String distributionId, String id) {setDistributionId(distributionId);setId(id);}
public static boolean endsWith(char s[], int len, String suffix) {final int suffixLen = suffix.length();if (suffixLen > len)return false;for (int i = suffixLen - 1; i >= 0; i--)if (s[len -(suffixLen - i)] != suffix.charAt(i))return false;return true;}
public int getScore() {return score;}
public NavigableSet<E> descendingSet() {return (descendingSet != null) ? descendingSet: (descendingSet = new TreeSet<E>(backingMap.descendingMap()));}
public BoundSheetRecord[] getBoundSheetRecords() {return boundSheetRecords.toArray(new BoundSheetRecord[0]);}
public void setDirCacheIterator(TreeWalk walk, int treeId) {state.walk = walk;state.dirCacheTree = treeId;}
public String toString() {return "AssociationFacetField(dim=" + dim + " path=" + Arrays.toString(path) + " bytes=" + assoc + ")";}
public ByteArrayDataOutput(byte[] bytes) {reset(bytes);}
public Explanation idfExplain(CollectionStatistics collectionStats, TermStatistics termStats[]) {double idf = 0d; List<Explanation> details = new ArrayList<>();for (final TermStatistics stat : termStats ) {Explanation idfExplain = idfExplain(collectionStats, stat);details.add(idfExplain);idf += idfExplain.getValue().floatValue();}return Explanation.match((float) idf, "idf, sum of:", details);}
public DoubleBuffer put(double[] src, int srcOffset, int doubleCount) {Arrays.checkOffsetAndCount(src.length, srcOffset, doubleCount);if (doubleCount > remaining()) {throw new BufferOverflowException();}for (int i = srcOffset; i < srcOffset + doubleCount; ++i) {put(src[i]);}return this;}
public DisassociateIamInstanceProfileResult disassociateIamInstanceProfile(DisassociateIamInstanceProfileRequest request) {request = beforeClientExecution(request);return executeDisassociateIamInstanceProfile(request);}
public void serialize(LittleEndianOutput out) {out.writeShort(field_1_x);out.writeShort(field_2_y);out.writeShort(field_3_topRow);out.writeShort(field_4_leftColumn);out.writeShort(field_5_activePane);}
public final int serialize(int offset, byte[] data) {int dataSize = getDataSize();int recSize = 4 + dataSize;try (LittleEndianByteArrayOutputStream out =new LittleEndianByteArrayOutputStream(data, offset, recSize)) {out.writeShort(getSid());out.writeShort(dataSize);serialize(out);if (out.getWriteIndex() - offset != recSize) {throw new IllegalStateException("Error in serialization of (" + getClass().getName() + "): "+ "Incorrect number of bytes written - expected " + recSize + " but got "+ (out.getWriteIndex() - offset));}} catch (IOException ioe) {throw new IllegalStateException(ioe);}return recSize;}
public STSAssumeRoleSessionCredentialsProvider withSTSClient(IAcsClient client) {this.stsClient = client;return this;}
public SearchGameSessionsResult searchGameSessions(SearchGameSessionsRequest request) {request = beforeClientExecution(request);return executeSearchGameSessions(request);}
public ListGraphsResult listGraphs(ListGraphsRequest request) {request = beforeClientExecution(request);return executeListGraphs(request);}
public PipedWriter(PipedReader destination) throws IOException {super(destination);connect(destination);}
public void clearDrawingGroups() {drawingGroups.clear();}
public static Date getJavaDate(double date, boolean use1904windowing, TimeZone tz, boolean roundSeconds) {Calendar calendar = getJavaCalendar(date, use1904windowing, tz, roundSeconds);return calendar == null ? null : calendar.getTime();}
public String toString() {StringBuilder sb = new StringBuilder();sb.append("[EXTERNALNAME]\n");sb.append("    .options = ").append(field_1_option_flag).append("\n");sb.append("    .ix      = ").append(field_2_ixals).append("\n");sb.append("    .name    = ").append(field_4_name).append("\n");if(field_5_name_definition != null) {Ptg[] ptgs = field_5_name_definition.getTokens();for (Ptg ptg : ptgs) {sb.append("    .namedef = ").append(ptg).append(ptg.getRVAType()).append("\n");}}sb.append("[/EXTERNALNAME]\n");return sb.toString();}
public Ref remove(Object key) {String name = toRefName((String) key);Ref res = null;int idx;if (0 <= (idx = packed.find(name))) {res = packed.get(name);packed = packed.remove(idx);sizeIsValid = false;}if (0 <= (idx = loose.find(name))) {res = loose.get(name);loose = loose.remove(idx);sizeIsValid = false;}if (0 <= (idx = resolved.find(name))) {res = resolved.get(name);resolved = resolved.remove(idx);sizeIsValid = false;}return res;}
public final String toString() {return getClass().getName() + " [" + lookupName(_functionIndex) + " nArgs=" + _numberOfArgs + "]";}
public String toString() {return "dels=" + Arrays.toString(item);}
public void println(double d) {println(String.valueOf(d));}
public ListAppsResult listApps(ListAppsRequest request) {request = beforeClientExecution(request);return executeListApps(request);}
public TokenStream create(TokenStream input) {return new GreekStemFilter(input);}
public String getEmailAddress() {return emailAddress;}
public GetDistributionRequest(String id) {setId(id);}
public V getValue() {return value;}
public GetRestApiResult getRestApi(GetRestApiRequest request) {request = beforeClientExecution(request);return executeGetRestApi(request);}
public AttachVpnGatewayResult attachVpnGateway(AttachVpnGatewayRequest request) {request = beforeClientExecution(request);return executeAttachVpnGateway(request);}
public void advance() {previousValue = value;if (value == 1) {value = minShingleSize;} else if (value == maxShingleSize) {reset();} else {++value;}}
public StashListCommand stashList() {return new StashListCommand(repo);}
public ICUNormalizer2CharFilterFactory(Map<String,String> args) {super(args);String form = get(args, "form", "nfkc_cf");String mode = get(args, "mode", Arrays.asList("compose", "decompose"), "compose");Normalizer2 normalizer = Normalizer2.getInstance(null, form, "compose".equals(mode) ? Normalizer2.Mode.COMPOSE : Normalizer2.Mode.DECOMPOSE);String filter = get(args, "filter");if (filter != null) {UnicodeSet set = new UnicodeSet(filter);if (!set.isEmpty()) {set.freeze();normalizer = new FilteredNormalizer2(normalizer, set);}}if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameters: " + args);}this.normalizer = normalizer;}
public AmazonS3EncryptionClient(AWSCredentials credentials,EncryptionMaterials encryptionMaterials) {this(credentials, new StaticEncryptionMaterialsProvider(encryptionMaterials));}
public StashCreateCommand setWorkingDirectoryMessage(String message) {workingDirectoryMessage = message;return this;}
public HSSFName getName(String name) {int nameIndex = getNameIndex(name);if (nameIndex < 0) {return null;}return names.get(nameIndex);}
public UpdateDomainNameResult updateDomainName(UpdateDomainNameRequest request) {request = beforeClientExecution(request);return executeUpdateDomainName(request);}
public LiteralValueSource(String string) {this.string = string;this.bytesRef = new BytesRef(string);}
public NormalisedDecimal createNormalisedDecimal(int pow10) {int missingUnderBits = _binaryExponent-39;int fracPart = (_significand.intValue() << missingUnderBits) & 0xFFFF80;long wholePart = _significand.shiftRight(C_64-_binaryExponent-1).longValue();return new NormalisedDecimal(wholePart, fracPart, pow10);}
public ListConfigurationsResult listConfigurations(ListConfigurationsRequest request) {request = beforeClientExecution(request);return executeListConfigurations(request);}
public static String trimFromLast(String str, String stripString) {int pos = str.lastIndexOf(stripString);if (pos > -1) {return str.substring(0, pos);} else {return str;}}
public void newField(FieldInfo fieldInfo) {count = interval;}
public UserSViewEnd(byte[] data) {_rawData = data;}
public HSSFFormulaEvaluator createFormulaEvaluator(){return new HSSFFormulaEvaluator(workbook);}
public void grow() {costs = ArrayUtil.grow(costs, 1+count);lastRightID = ArrayUtil.grow(lastRightID, 1+count);backPos = ArrayUtil.grow(backPos, 1+count);backWordPos = ArrayUtil.grow(backWordPos, 1+count);backIndex = ArrayUtil.grow(backIndex, 1+count);backID = ArrayUtil.grow(backID, 1+count);final Type[] newBackType = new Type[backID.length];System.arraycopy(backType, 0, newBackType, 0, backType.length);backType = newBackType;}
public synchronized void reset() throws IOException {if (buf == null) {throw new IOException("Stream is closed");}if (-1 == markpos) {throw new IOException("Mark has been invalidated.");}pos = markpos;}
public String toString() {if (getChildren() == null || getChildren().size() == 0)return "<boolean operation='or'/>";StringBuilder sb = new StringBuilder();sb.append("<boolean operation='or'>");for (QueryNode child : getChildren()) {sb.append("\n");sb.append(child.toString());}sb.append("\n</boolean>");return sb.toString();}
public PullCommand pull() {return new PullCommand(repo);}
public UpdateCompanyNetworkConfigurationResult updateCompanyNetworkConfiguration(UpdateCompanyNetworkConfigurationRequest request) {request = beforeClientExecution(request);return executeUpdateCompanyNetworkConfiguration(request);}
public HSSFClientAnchor createAnchor(int dx1, int dy1, int dx2, int dy2, int col1, int row1, int col2, int row2) {return new HSSFClientAnchor(dx1, dy1, dx2, dy2, (short) col1, row1, (short) col2, row2);}
public int find(String key) {int len = key.length();char strkey[] = new char[len + 1];key.getChars(0, len, strkey, 0);strkey[len] = 0;return find(strkey, 0);}
public WriteRequest(DeleteRequest deleteRequest) {setDeleteRequest(deleteRequest);}
public ScoreCachingWrappingScorer(Scorable scorer) {this.in = scorer;}
public UTF8Sequence() {bytes = new UTF8Byte[4];for(int i=0;i<4;i++) {bytes[i] = new UTF8Byte();}}
public CreateCollectionResult createCollection(CreateCollectionRequest request) {request = beforeClientExecution(request);return executeCreateCollection(request);}
public FieldAndTerm clone() {return new FieldAndTerm(this);}
public DescribeVolumesResult describeVolumes() {return describeVolumes(new DescribeVolumesRequest());}
@Override public int indexOf(Object object) {final int size;final Object[] array;synchronized (mutex) {size = list.size();array = new Object[size];list.toArray(array);}if (object != null) {for (int i = 0; i < size; i++) {if (object.equals(array[i])) {return i;}}} else {for (int i = 0; i < size; i++) {if (array[i] == null) {return i;}}}return -1;}
public PrecedenceQueryParser() {setQueryNodeProcessor(new PrecedenceQueryNodeProcessorPipeline(getQueryConfigHandler()));}
public DescribeDatasetGroupResult describeDatasetGroup(DescribeDatasetGroupRequest request) {request = beforeClientExecution(request);return executeDescribeDatasetGroup(request);}
public void serialize(LittleEndianOutput out) {out.writeInt(0);out.writeInt(getFirstRow());out.writeInt(getLastRowAdd1());out.writeInt(field_4_zero);for (int k = 0; k < getNumDbcells(); k++) {out.writeInt(getDbcellAt(k));}}
public final String get(String name) {for (IndexableField field : fields) {if (field.name().equals(name) && field.stringValue() != null) {return field.stringValue();}}return null;}
public GetPhotosRequest() {super("CloudPhoto", "2017-07-11", "GetPhotos", "cloudphoto");setProtocol(ProtocolType.HTTPS);}
public synchronized void write(byte[] buffer, int offset, int length) throws IOException {checkNotClosed();if (buffer == null) {throw new NullPointerException("buffer == null");}byte[] internalBuffer = buf;if (length >= internalBuffer.length) {flushInternal();out.write(buffer, offset, length);return;}Arrays.checkOffsetAndCount(buffer.length, offset, length);if (length > (internalBuffer.length - count)) {flushInternal();}System.arraycopy(buffer, offset, internalBuffer, count, length);count += length;}
public CopySnapshotResult copySnapshot(CopySnapshotRequest request) {request = beforeClientExecution(request);return executeCopySnapshot(request);}
public void set(char[] arr, int end) {this.buf = arr;this.len = end;}
public void copyArea(int x, int y, int width, int height, int dx, int dy){if (logger.check( POILogger.WARN ))logger.log(POILogger.WARN,"copyArea not supported");}
public void merge(TextFragment frag2){textEndPos = frag2.textEndPos;score=Math.max(score,frag2.score);}
public PropertyTable(HeaderBlock headerBlock){_header_block = headerBlock;_bigBigBlockSize = headerBlock.getBigBlockSize();addProperty(new RootProperty());}
@Override public Iterator<Multiset.Entry<E>> iterator() {final Iterator<Map.Entry<E, AtomicInteger>> backingEntries= backingMap.entrySet().iterator();return new Iterator<Multiset.Entry<E>>() {Map.Entry<E, AtomicInteger> toRemove;
public static Cell createCell(Row row, int column, String value) {return createCell(row, column, value, null);}
public ImportRestApiResult importRestApi(ImportRestApiRequest request) {request = beforeClientExecution(request);return executeImportRestApi(request);}
public BrazilianStemFilterFactory(Map<String,String> args) {super(args);if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameters: " + args);}}
public static boolean isUnicodeString(final String value) {return !value.equals(new String(value.getBytes(ISO_8859_1), ISO_8859_1));}
public static void writeHeader(DataOutput out, String codec, int version) throws IOException {BytesRef bytes = new BytesRef(codec);if (bytes.length != codec.length() || bytes.length >= 128) {throw new IllegalArgumentException("codec must be simple ASCII, less than 128 characters in length [got " + codec + "]");}out.writeInt(CODEC_MAGIC);out.writeString(codec);out.writeInt(version);}
public static Collection<String> getSupportedFunctionNames() {Collection<String> lst = new TreeSet<>();for (int i = 0; i < functions.length; i++) {Function func = functions[i];FunctionMetadata metaData = FunctionMetadataRegistry.getFunctionByIndex(i);if (func != null && !(func instanceof NotImplementedFunction)) {lst.add(metaData.getName());}}lst.add("INDIRECT"); return Collections.unmodifiableCollection(lst);}
public DescribeInterconnectsResult describeInterconnects(DescribeInterconnectsRequest request) {request = beforeClientExecution(request);return executeDescribeInterconnects(request);}
public BytesRef getPayload() {if (payloadLength == 0) {return null;} else {return payload;}}
public MigrateWorkspaceResult migrateWorkspace(MigrateWorkspaceRequest request) {request = beforeClientExecution(request);return executeMigrateWorkspace(request);}
public ListSentimentDetectionJobsResult listSentimentDetectionJobs(ListSentimentDetectionJobsRequest request) {request = beforeClientExecution(request);return executeListSentimentDetectionJobs(request);}
public void write(LittleEndianOutput out) {out.writeByte(sid + getPtgClass());out.writeByte(field_1_error_code);}
public static Calendar getJavaCalendar(double date, boolean use1904windowing) {return getJavaCalendar(date, use1904windowing, null, false);}
public V nextElement() { return nextEntryNotFailFast().value; }
public int indexOf(Object object) {Object[] snapshot = elements;return indexOf(object, snapshot, 0, snapshot.length);}
public DescribeTextTranslationJobResult describeTextTranslationJob(DescribeTextTranslationJobRequest request) {request = beforeClientExecution(request);return executeDescribeTextTranslationJob(request);}
public void ReInit(CharStream stream, int lexState){ReInit(stream);SwitchTo(lexState);}
public GetFederationTokenRequest(String name) {setName(name);}
public ShortBuffer asReadOnlyBuffer() {return ReadOnlyShortArrayBuffer.copy(this, mark);}
public void readBytes(byte[] b, int offset, int len) {for(int i=0;i<len;i++) {b[offset+i] = bytes[pos--];}}
public GetRelationalDatabaseSnapshotResult getRelationalDatabaseSnapshot(GetRelationalDatabaseSnapshotRequest request) {request = beforeClientExecution(request);return executeGetRelationalDatabaseSnapshot(request);}
public String toString() {return "SnapshotDeletionPolicy.SnapshotCommitPoint(" + cp + ")";}
public DescribeAddressesResult describeAddresses() {return describeAddresses(new DescribeAddressesRequest());}
public GetInvitationConfigurationResult getInvitationConfiguration(GetInvitationConfigurationRequest request) {request = beforeClientExecution(request);return executeGetInvitationConfiguration(request);}
public Cluster disableSnapshotCopy(DisableSnapshotCopyRequest request) {request = beforeClientExecution(request);return executeDisableSnapshotCopy(request);}
public ReplicationGroup modifyReplicationGroup(ModifyReplicationGroupRequest request) {request = beforeClientExecution(request);return executeModifyReplicationGroup(request);}
public GetSendQuotaResult getSendQuota(GetSendQuotaRequest request) {request = beforeClientExecution(request);return executeGetSendQuota(request);}
public PrecedenceQueryNodeProcessorPipeline(QueryConfigHandler queryConfig) {super(queryConfig);for (int i = 0 ; i < size() ; i++) {if (get(i).getClass().equals(BooleanQuery2ModifierNodeProcessor.class)) {remove(i--);}}add(new BooleanModifiersQueryNodeProcessor());}
public int get(int forwardId, int backwardId) {int offset = (backwardId * forwardSize + forwardId) * 2;return buffer.getShort(offset);}
public ModifySpotFleetRequestResult modifySpotFleetRequest(ModifySpotFleetRequestRequest request) {request = beforeClientExecution(request);return executeModifySpotFleetRequest(request);}
public short setShort(final short holder){return ( short ) set(holder);}
public RegisterTagRequest() {super("CloudPhoto", "2017-07-11", "RegisterTag", "cloudphoto");setProtocol(ProtocolType.HTTPS);}
public CreateDocumentClassifierResult createDocumentClassifier(CreateDocumentClassifierRequest request) {request = beforeClientExecution(request);return executeCreateDocumentClassifier(request);}
public NameXPtg getNameXPtg(String name, UDFFinder udf) {return getNameXPtg(name, -1, udf);}
public UpdateScalingParametersResult updateScalingParameters(UpdateScalingParametersRequest request) {request = beforeClientExecution(request);return executeUpdateScalingParameters(request);}
public StatusCommand status() {return new StatusCommand(repo);}
public void setRoleName(String roleName) {if (null == roleName) {throw new NullPointerException("You must specifiy a valid role name.");}this.roleName = roleName;setCredentialUrl();}
public int size() {synchronized (lock) {return count;}}
public SeriesListRecord(RecordInputStream in) {int nItems = in.readUShort();short[] ss = new short[nItems];for (int i = 0; i < nItems; i++) {ss[i] = in.readShort();}field_1_seriesNumbers = ss;}
public boolean add(E object) {return backingMap.put(object, Boolean.TRUE) == null;}
public String getText() {if (getChildCount() == 0) {return "";}StringBuilder builder = new StringBuilder();for (int i = 0; i < getChildCount(); i++) {builder.append(getChild(i).getText());}return builder.toString();}
public DescribeLogStreamsRequest(String logGroupName) {setLogGroupName(logGroupName);}
public PhRun(int phoneticTextFirstCharacterOffset,int realTextFirstCharacterOffset, int realTextLength) {this.phoneticTextFirstCharacterOffset = phoneticTextFirstCharacterOffset;this.realTextFirstCharacterOffset = realTextFirstCharacterOffset;this.realTextLength = realTextLength;}
public DeleteAccessPointResult deleteAccessPoint(DeleteAccessPointRequest request) {request = beforeClientExecution(request);return executeDeleteAccessPoint(request);}
public UpdateRequestValidatorResult updateRequestValidator(UpdateRequestValidatorRequest request) {request = beforeClientExecution(request);return executeUpdateRequestValidator(request);}
public CreateProjectResult createProject(CreateProjectRequest request) {request = beforeClientExecution(request);return executeCreateProject(request);}
public NormalisedDecimal roundUnits() {long wholePart = _wholePart;if (_fractionalPart >= FRAC_HALF) {wholePart++;}int de = _relativeDecimalExponent;if (wholePart < MAX_REP_WHOLE_PART) {return new NormalisedDecimal(wholePart, 0, de);}return new NormalisedDecimal(wholePart/10, 0, de+1);}
public float docScore(int docId, String field, int numPayloadsSeen, float payloadScore) {return numPayloadsSeen > 0 ? payloadScore : 1;}
public UpdateSubnetGroupResult updateSubnetGroup(UpdateSubnetGroupRequest request) {request = beforeClientExecution(request);return executeUpdateSubnetGroup(request);}
public ValidateConfigurationResult validateConfiguration(ValidateConfigurationRequest request) {request = beforeClientExecution(request);return executeValidateConfiguration(request);}
public String dequote(byte[] in, int ip, int ie) {boolean inquote = false;final byte[] r = new byte[ie - ip];int rPtr = 0;while (ip < ie) {final byte b = in[ip++];switch (b) {case '\'':inquote = !inquote;continue;case '\\':if (inquote || ip == ie)r[rPtr++] = b; elser[rPtr++] = in[ip++];continue;default:r[rPtr++] = b;continue;}}return RawParseUtils.decode(UTF_8, r, 0, rPtr);}
public void clearRect(int x, int y, int width, int height){Color color = foreground;setColor(background);fillRect(x,y,width,height);setColor(color);}
public Type getType() {return type;}
public CellRangeAddress getAreaAt(int index) {return _regions[_startIndex + index];}
public String toString() {return "EditList" + super.toString(); }
public SrndQuery parse2(String query) throws ParseException {ReInit(new FastCharStream(new StringReader(query)));try {return TopSrndQuery();} catch (TokenMgrError tme) {throw new ParseException(tme.getMessage());}}
public ProtectRecord clone() {return copy();}
public DeleteEventBusResult deleteEventBus(DeleteEventBusRequest request) {request = beforeClientExecution(request);return executeDeleteEventBus(request);}
public <T> Collection<T> getAllMatchingGroups() {return (Collection<T>) matchingGroups;}
public String getPromptText() {return promptText;}
public static FontUnderline valueOf(int value){return _table[value];}
public ByteBuffer putShort(int index, short value) {throw new ReadOnlyBufferException();}
public static String longToHex(long value) {StringBuilder sb = new StringBuilder(18);writeHex(sb, value, 16, "0x");return sb.toString();}
public DeleteRouteSettingsResult deleteRouteSettings(DeleteRouteSettingsRequest request) {request = beforeClientExecution(request);return executeDeleteRouteSettings(request);}
public ModifyInstanceEventStartTimeResult modifyInstanceEventStartTime(ModifyInstanceEventStartTimeRequest request) {request = beforeClientExecution(request);return executeModifyInstanceEventStartTime(request);}
public boolean equals(Object other) {return sameClassAs(other) &&func.equals(((FunctionQuery) other).func);}
public void tagResource(TagResourceRequest request) {request = beforeClientExecution(request);executeTagResource(request);}
public static String stripTags(String buf, int start) {if (start>0) {buf = buf.substring(start);}return buf.replaceAll("<[^>]*>", " ");}
public final String toString() {StringBuilder sb = new StringBuilder();String recordName = getRecordName();sb.append("[").append(recordName).append("]\n");sb.append("    .row    = ").append(HexDump.shortToHex(getRow())).append("\n");sb.append("    .col    = ").append(HexDump.shortToHex(getColumn())).append("\n");sb.append("    .xfindex= ").append(HexDump.shortToHex(getXFIndex())).append("\n");appendValueText(sb);sb.append("\n");sb.append("[/").append(recordName).append("]\n");return sb.toString();}
public DescribeRuleResult describeRule(DescribeRuleRequest request) {request = beforeClientExecution(request);return executeDescribeRule(request);}
public UpdateSegmentResult updateSegment(UpdateSegmentRequest request) {request = beforeClientExecution(request);return executeUpdateSegment(request);}
public BatchDeleteClusterSnapshotsResult batchDeleteClusterSnapshots(BatchDeleteClusterSnapshotsRequest request) {request = beforeClientExecution(request);return executeBatchDeleteClusterSnapshots(request);}
public PushCommand setDryRun(boolean dryRun) {checkCallable();this.dryRun = dryRun;return this;}
public GetCurrentUserResult getCurrentUser(GetCurrentUserRequest request) {request = beforeClientExecution(request);return executeGetCurrentUser(request);}
public SetIdentityNotificationTopicResult setIdentityNotificationTopic(SetIdentityNotificationTopicRequest request) {request = beforeClientExecution(request);return executeSetIdentityNotificationTopic(request);}
public void serialize(LittleEndianOutput out) {out.writeShort(rt);out.writeShort(grbitFrt);out.writeShort(iObjectKind);out.write(reserved);}
public byte readByte() {assert !eof();assert upto <= limit;if (upto == limit)nextSlice();return buffer[upto++];}
public NotImplementedFunctionException(String functionName) {super(functionName);this.functionName = functionName;}
public DescribeTemplateAliasResult describeTemplateAlias(DescribeTemplateAliasRequest request) {request = beforeClientExecution(request);return executeDescribeTemplateAlias(request);}
public ModifyDBInstanceRequest(String dBInstanceIdentifier) {setDBInstanceIdentifier(dBInstanceIdentifier);}
public long next() {final long idx = 1 + (ord / indexInterval);if (idx >= fieldIndex.numIndexTerms) {return -1;}ord += indexInterval;final long offset = fieldIndex.termOffsets.get(idx);final int length = (int) (fieldIndex.termOffsets.get(1+idx) - offset);termBytesReader.fillSlice(term, fieldIndex.termBytesStart + offset, length);return fieldIndex.termsStart + fieldIndex.termsDictOffsets.get(idx);}
public EvaluationCell getCell(int rowIndex, int columnIndex) {HSSFRow row = _hs.getRow(rowIndex);if (row == null) {return null;}HSSFCell cell = row.getCell(columnIndex);if (cell == null) {return null;}return new HSSFEvaluationCell(cell, this);}
@Override public boolean equals(Object o) {if (o instanceof Map.Entry) {Map.Entry other = (Map.Entry) o;return (key == null ? other.getKey() == null : key.equals(other.getKey()))&& (value == null ? other.getValue() == null : value.equals(other.getValue()));}return false;}
public DescribeClusterSnapshotsResult describeClusterSnapshots() {return describeClusterSnapshots(new DescribeClusterSnapshotsRequest());}
public int readUShort() {return readShort() & 0xFFFF;}
public boolean equals(Object obj) {if (this == obj) {return true;}if (obj == null) {return false;}if (getClass() != obj.getClass()) {return false;}ExpressionValueSource other = (ExpressionValueSource) obj;if (expression == null) {if (other.expression != null) {return false;}} else if (!expression.sourceText.equals(other.expression.sourceText)) {return false;}if (needsScores != other.needsScores) {return false;}if (!Arrays.equals(variables, other.variables)) {return false;}return true;}
public int getPort() {return Host.this.getPort();}
public LinkFaceRequest() {super("LinkFace", "2018-07-20", "LinkFace");setProtocol(ProtocolType.HTTPS);setMethod(MethodType.POST);}
public ListTagsForStreamResult listTagsForStream(ListTagsForStreamRequest request) {request = beforeClientExecution(request);return executeListTagsForStream(request);}
public SSTRecord() {field_1_num_strings = 0;field_2_num_unique_strings = 0;field_3_strings = new IntMapper<>();deserializer = new SSTDeserializer(field_3_strings);}
public QueryText getPathElement(int index) {return values.get(index);}
public Ole10Native(String label, String filename, String command, byte[] data) {setLabel(label);setFileName(filename);setCommand(command);setDataBuffer(data);mode = EncodingMode.parsed;}
public String toString() {return super.toString();}
public DBCluster restoreDBClusterFromS3(RestoreDBClusterFromS3Request request) {request = beforeClientExecution(request);return executeRestoreDBClusterFromS3(request);}
public DocumentStoredFieldVisitor(String... fields) {fieldsToAdd = new HashSet<>(fields.length);for(String field : fields) {fieldsToAdd.add(field);}}
public SheetRefEvaluator getSheetEvaluator(int sheetIndex) {if (sheetIndex < _firstSheetIndex || sheetIndex > _lastSheetIndex) {throw new IllegalArgumentException("Invalid SheetIndex: " + sheetIndex +" - Outside range " + _firstSheetIndex + " : " + _lastSheetIndex);}return _sheetEvaluators[sheetIndex-_firstSheetIndex];}
public EveryNOrDocFreqTermSelector(int docFreqThresh, int interval) {this.interval = interval;this.docFreqThresh = docFreqThresh;count = interval;}
public static synchronized CoderResult unmappableForLength(int length)throws IllegalArgumentException {if (length > 0) {Integer key = Integer.valueOf(length);synchronized (_unmappableErrors) {CoderResult r = _unmappableErrors.get(key);if (r == null) {r = new CoderResult(TYPE_UNMAPPABLE_CHAR, length);_unmappableErrors.put(key, r);}return r;}}throw new IllegalArgumentException("Length must be greater than 0; was " + length);}
public FacetEntry(BytesRef value, int count) {this.value = value;this.count = count;}
public CharSequence toQueryString(EscapeQuerySyntax escapeSyntaxParser) {return "@" + this.schema + ":'" + this.value + "'";}
static public double ppmt(double r, int per, int nper, double pv, double fv, int type) {return pmt(r, nper, pv, fv, type) - ipmt(r, per, nper, pv, fv, type);}
public PredictCategoryRequest() {super("visionai-poc", "2020-04-08", "PredictCategory");setMethod(MethodType.POST);}
public static final String toString(ObjectId i) {return i != null ? i.name() : ZEROID_STR;}
public int remove(Object key) {boolean hashedOk;int index, next, hash;int result;Object object;index = next = findIndex(key, keys);if (keys[index] != key) {return -1;}result = values[index];int length = keys.length;while (true) {next = (next + 2) % length;object = keys[next];if (object == null) {break;}hash = getModuloHash(object, length);hashedOk = hash > index;if (next < index) {hashedOk = hashedOk || (hash <= next);} else {hashedOk = hashedOk && (hash <= next);}if (!hashedOk) {keys[index] = object;values[index] = values[next];index = next;}}size--;keys[index] = null;values[index] = -1;return result;}
public MultiSimilarity(Similarity sims[]) {this.sims = sims;}
public UpdateFolderResult updateFolder(UpdateFolderRequest request) {request = beforeClientExecution(request);return executeUpdateFolder(request);}
public ParseTree get(String label) {List<ParseTree> parseTrees = labels.get(label);if ( parseTrees==null || parseTrees.size()==0 ) {return null;}return parseTrees.get( parseTrees.size()-1 ); }
public CancelStepsResult cancelSteps(CancelStepsRequest request) {request = beforeClientExecution(request);return executeCancelSteps(request);}
public AttachVpnGatewayRequest(String vpnGatewayId, String vpcId) {setVpnGatewayId(vpnGatewayId);setVpcId(vpcId);}
public byte[] toByteArray() {return build();}
public StopTrainingEntityRecognizerResult stopTrainingEntityRecognizer(StopTrainingEntityRecognizerRequest request) {request = beforeClientExecution(request);return executeStopTrainingEntityRecognizer(request);}
public FrenchMinimalStemFilterFactory(Map<String,String> args) {super(args);if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameters: " + args);}}
public DBInstance modifyDBInstance(ModifyDBInstanceRequest request) {request = beforeClientExecution(request);return executeModifyDBInstance(request);}
