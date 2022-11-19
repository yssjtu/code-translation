public CopyWorkspaceImageResult copyWorkspaceImage(CopyWorkspaceImageRequest request) {request = beforeClientExecution(request);return executeCopyWorkspaceImage(request);}
public CharBuffer slice() {byteBuffer.limit(limit * SizeOf.CHAR);byteBuffer.position(position * SizeOf.CHAR);ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());CharBuffer result = new CharToByteBufferAdapter(bb);byteBuffer.clear();return result;}
public ValueEval evaluate(int srcRowIndex, int srcColumnIndex, ValueEval textArg) {ValueEval veText1;try {veText1 = OperandResolver.getSingleValue(textArg, srcRowIndex, srcColumnIndex);} catch (EvaluationException e) {return e.getErrorEval();}String text = OperandResolver.coerceValueToString(veText1);if (text.length() == 0) {return ErrorEval.VALUE_INVALID;}int code = text.charAt(0);return new StringEval(String.valueOf(code));}
public void SwitchTo(int lexState){if (lexState >= 3 || lexState < 0)throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);elsecurLexState = lexState;}
public ShortBuffer slice() {return new ReadOnlyShortArrayBuffer(remaining(), backingArray, offset + position);}
public NameCommentRecord(final RecordInputStream ris) {field_1_record_type = ris.readShort();field_2_frt_cell_ref_flag = ris.readShort();field_3_reserved = ris.readLong();final int field_4_name_length = ris.readShort();final int field_5_comment_length = ris.readShort();if (ris.readByte() == 0) {field_6_name_text = StringUtil.readCompressedUnicode(ris, field_4_name_length);} else {field_6_name_text = StringUtil.readUnicodeLE(ris, field_4_name_length);}if (ris.readByte() == 0) {field_7_comment_text = StringUtil.readCompressedUnicode(ris, field_5_comment_length);} else {field_7_comment_text = StringUtil.readUnicodeLE(ris, field_5_comment_length);}}
public ValueEval evaluate(int srcRowIndex, int srcColumnIndex, ValueEval arg0) {ValueEval ve;try {ve = OperandResolver.getSingleValue(arg0, srcRowIndex, srcColumnIndex);} catch (EvaluationException e) {ve = e.getErrorEval();}return BoolEval.valueOf(evaluate(ve));}
public int ordVal(int doc) throws IOException {throw new UnsupportedOperationException();}
public GetStatusResult getStatus(GetStatusRequest request) {request = beforeClientExecution(request);return executeGetStatus(request);}
public static void byteArray(StringBuilder buffer, byte[] bytes) {for (int i = 0; i < bytes.length; i++) {buffer.append("b[").append(i).append("]=").append(bytes[i]);if (i < bytes.length - 1) {buffer.append(',');}}}
public final byte get() {if (position == limit) {throw new BufferUnderflowException();}return backingArray[offset + position++];}
public DescribeTrafficMirrorTargetsResult describeTrafficMirrorTargets(DescribeTrafficMirrorTargetsRequest request) {request = beforeClientExecution(request);return executeDescribeTrafficMirrorTargets(request);}
public ModifyClusterParameterGroupResult modifyClusterParameterGroup(ModifyClusterParameterGroupRequest request) {request = beforeClientExecution(request);return executeModifyClusterParameterGroup(request);}
public long getTotalSLLLookaheadOps() {DecisionInfo[] decisions = atnSimulator.getDecisionInfo();long k = 0;for (int i = 0; i < decisions.length; i++) {k += decisions[i].SLL_TotalLook;}return k;}
public static int idealIntArraySize(int need) {return idealByteArraySize(need * 4) / 4;}
public StopInstancesRequest(java.util.List<String> instanceIds) {setInstanceIds(instanceIds);}
public synchronized boolean isIndeterminate() {return mIndeterminate;}
public CreateImportJobResult createImportJob(CreateImportJobRequest request) {request = beforeClientExecution(request);return executeCreateImportJob(request);}
public void write(LittleEndianOutput out) {out.writeByte(getSid() + getPtgClass());writeCoordinates(out);}
public DeleteReceiptRuleResult deleteReceiptRule(DeleteReceiptRuleRequest request) {request = beforeClientExecution(request);return executeDeleteReceiptRule(request);}
public DescribeFleetCapacityResult describeFleetCapacity(DescribeFleetCapacityRequest request) {request = beforeClientExecution(request);return executeDescribeFleetCapacity(request);}
public PutIntegrationResponseResult putIntegrationResponse(PutIntegrationResponseRequest request) {request = beforeClientExecution(request);return executePutIntegrationResponse(request);}
public MergeAlgorithm(DiffAlgorithm diff) {this.diffAlg = diff;}
public final boolean matches(char c) {return Character.isDigit(c);}
public long estimateBytesUsed() {return bytesUsed;}
public StashCreateCommand(Repository repo) {super(repo);person = new PersonIdent(repo);}
public void write(byte[] b, int off, int len) throws IOException {if ((off < 0) || (off > b.length) || (len < 0) ||((off + len) > b.length) || ((off + len) < 0)) {throw new IndexOutOfBoundsException();} else if (len == 0) {return;}do {createBlockIfNeeded();int writeBytes = Math.min(buffer.remaining(), len);buffer.put(b, off, writeBytes);off += writeBytes;len -= writeBytes;} while (len > 0);}
public short clearShort(final short holder){return ( short ) clear(holder);}
public DeltaIndex(byte[] sourceBuffer) {src = sourceBuffer;DeltaIndexScanner scan = new DeltaIndexScanner(src, src.length);table = scan.table;tableMask = scan.tableMask;entries = new long[1 + countEntries(scan)];copyEntries(scan);}
public Count(){_predicate = defaultPredicate;}
public CreateIntegrationResult createIntegration(CreateIntegrationRequest request) {request = beforeClientExecution(request);return executeCreateIntegration(request);}
public synchronized void mark(int ignoredReadlimit) {_marked_offset = _current_offset;_marked_offset_count = Math.max(0, _current_block_count - 1);}
public CollatedTermAttributeImpl(Collator collator) {this.collator = (Collator) collator.clone();}
public CharBuffer duplicate() {return copy(this, mark);}
public Certificate modifyCertificates(ModifyCertificatesRequest request) {request = beforeClientExecution(request);return executeModifyCertificates(request);}
@Override public Collection<V> values() {Collection<V> vs = values;return (vs != null) ? vs : (values = new Values());}
public synchronized boolean add(E object) {if (elementCount == elementData.length) {growByOne();}elementData[elementCount++] = object;modCount++;return true;}
public ListDeliverabilityTestReportsResult listDeliverabilityTestReports(ListDeliverabilityTestReportsRequest request) {request = beforeClientExecution(request);return executeListDeliverabilityTestReports(request);}
public String getTokenName(int t) {if (t == Token.EOF) {return "EOF";}Vocabulary vocabulary = parser != null ? parser.getVocabulary() : VocabularyImpl.EMPTY_VOCABULARY;String displayName = vocabulary.getDisplayName(t);if (displayName.equals(Integer.toString(t))) {return displayName;}return displayName + "<" + t + ">";}
public GetHostedZoneRequest(String id) {setId(id);}
public ListOutgoingTypedLinksResult listOutgoingTypedLinks(ListOutgoingTypedLinksRequest request) {request = beforeClientExecution(request);return executeListOutgoingTypedLinks(request);}
public BatchDeleteAttributesRequest(String domainName, java.util.List<DeletableItem> items) {setDomainName(domainName);setItems(items);}
public short readShort(){return _in.readShort();}
public LongBuffer compact() {throw new ReadOnlyBufferException();}
public UnbufferedCharStream(Reader input, int bufferSize) {this(bufferSize);this.input = input;fill(1); }
public CleanCommand setPaths(Set<String> paths) {this.paths = paths;return this;}
public long hash1(char c) {final long p = 1099511628211L;long hash = 0xcbf29ce484222325L;hash = (hash ^ (c & 0x00FF)) * p;hash = (hash ^ (c >> 8)) * p;hash += hash << 13;hash ^= hash >> 7;hash += hash << 3;hash ^= hash >> 17;hash += hash << 5;return hash;}
public void split() throws IOException {boolean success = false;DirectoryReader reader = DirectoryReader.open(input);try {createIndex(config1, dir1, reader, docsInFirstIndex, false);createIndex(config2, dir2, reader, docsInFirstIndex, true);success = true;} finally {if (success) {IOUtils.close(reader);} else {IOUtils.closeWhileHandlingException(reader);}}}
public static IntBuffer wrap(int[] array) {return wrap(array, 0, array.length);}
public String toString() {String padd = getPadding();StringBuilder sb = new StringBuilder(super.toString());sb.append(parallel ? " [" : " {");sb.append(NEW_LINE);for (final PerfTask task : tasks) {sb.append(task.toString());sb.append(NEW_LINE);}sb.append(padd);sb.append(!letChildReport ? ">" : (parallel ? "]" : "}"));if (fixedTime) {sb.append(' ').append(NumberFormat.getNumberInstance(Locale.ROOT).format(runTimeSec)).append('s');} else if (repetitions>1) {sb.append(" * ").append(repetitions);} else if (repetitions==REPEAT_EXHAUST) {sb.append(" * EXHAUST");}if (rate>0) {sb.append(",  rate: ").append(rate).append('/').append(perMin ? "min" : "sec");}if (getRunInBackground()) {sb.append(" &");int x = getBackgroundDeltaPriority();if (x != 0) {sb.append(x);}}return sb.toString();}
public BytesRef(int capacity) {this.bytes = new byte[capacity];}
public StartMatchBackfillResult startMatchBackfill(StartMatchBackfillRequest request) {request = beforeClientExecution(request);return executeStartMatchBackfill(request);}
public DescribeImagesResult describeImages(DescribeImagesRequest request) {request = beforeClientExecution(request);return executeDescribeImages(request);}
public synchronized void setLength(int length) {super.setLength(length);}
public StartSmartHomeApplianceDiscoveryResult startSmartHomeApplianceDiscovery(StartSmartHomeApplianceDiscoveryRequest request) {request = beforeClientExecution(request);return executeStartSmartHomeApplianceDiscovery(request);}
public RuleTransition(RuleStartState ruleStart,int ruleIndex,int precedence,ATNState followState){super(ruleStart);this.ruleIndex = ruleIndex;this.precedence = precedence;this.followState = followState;}
public void readFully(byte[] buf, int off, int len){_in.readFully(buf, off, len);}
public UserInputQueryBuilder(QueryParser parser) {this.unSafeParser = parser;}
public DescribeIdentityPoolResult describeIdentityPool(DescribeIdentityPoolRequest request) {request = beforeClientExecution(request);return executeDescribeIdentityPool(request);}
public QueryParserConfig build() {return new QueryParserConfig(this);}
public PendingTaskCount countPendingActivityTasks(CountPendingActivityTasksRequest request) {request = beforeClientExecution(request);return executeCountPendingActivityTasks(request);}
public DeleteTrialComponentResult deleteTrialComponent(DeleteTrialComponentRequest request) {request = beforeClientExecution(request);return executeDeleteTrialComponent(request);}
public String toString() {if (getChildren() == null || getChildren().size() == 0)return "<tokenizedphrase/>";StringBuilder sb = new StringBuilder();sb.append("<tokenizedtphrase>");for (QueryNode child : getChildren()) {sb.append("\n");sb.append(child.toString());}sb.append("\n</tokenizedphrase>");return sb.toString();}
public TermsEnumIndex(TermsEnum termsEnum, int subIndex) {this.termsEnum = termsEnum;this.subIndex = subIndex;}
public int getHeight() {return mImage.getHeight();}
public Restrictions(GeoRestriction geoRestriction) {setGeoRestriction(geoRestriction);}
public SendBulkTemplatedEmailResult sendBulkTemplatedEmail(SendBulkTemplatedEmailRequest request) {request = beforeClientExecution(request);return executeSendBulkTemplatedEmail(request);}
public PagedMutable(long size, int pageSize, int bitsPerValue, float acceptableOverheadRatio) {this(size, pageSize, PackedInts.fastestFormatAndBits(pageSize, bitsPerValue, acceptableOverheadRatio));fillPages();}
public GetLibraryRequest() {super("CloudPhoto", "2017-07-11", "GetLibrary", "cloudphoto");setProtocol(ProtocolType.HTTPS);}
public static void fill(long[] array, long value) {for (int i = 0; i < array.length; i++) {array[i] = value;}}
public DeleteAliasResult deleteAlias(DeleteAliasRequest request) {request = beforeClientExecution(request);return executeDeleteAlias(request);}
public Object merge(Object first, Object second) {List<T> outputList = new ArrayList<>();if (!(first instanceof List)) {outputList.add((T) first);} else {outputList.addAll((List<T>) first);}if (!(second instanceof List)) {outputList.add((T) second);} else {outputList.addAll((List<T>) second);}return outputList;}
public HSSFClientAnchor createClientAnchor(){return new HSSFClientAnchor();}
public ListQualificationRequestsResult listQualificationRequests(ListQualificationRequestsRequest request) {request = beforeClientExecution(request);return executeListQualificationRequests(request);}
public int read() {if (ptr == data.length)return -1;return data[ptr++] & 0xff;}
public boolean isSupported(int bitsPerValue) {return bitsPerValue >= 1 && bitsPerValue <= 64;}
public ReleaseAddressRequest(String publicIp) {setPublicIp(publicIp);}
public DeleteClusterSecurityGroupResult deleteClusterSecurityGroup(DeleteClusterSecurityGroupRequest request) {request = beforeClientExecution(request);return executeDeleteClusterSecurityGroup(request);}
public CreateProfilingGroupResult createProfilingGroup(CreateProfilingGroupRequest request) {request = beforeClientExecution(request);return executeCreateProfilingGroup(request);}
public MatchResult toMatchResult() {ensureMatch();return new MatchResultImpl(input, matchOffsets);}
public DescribeInstallationMediaResult describeInstallationMedia(DescribeInstallationMediaRequest request) {request = beforeClientExecution(request);return executeDescribeInstallationMedia(request);}
public String toString() {return "INDEX_DIFF_FILTER"; }
public Class<ConfigChangedListener> getListenerType() {return ConfigChangedListener.class;}
public DBCluster stopDBCluster(StopDBClusterRequest request) {request = beforeClientExecution(request);return executeStopDBCluster(request);}
public String getName() {return name;}
public PrintWriter append(char c) {write(c);return this;}
public AcceptVpcPeeringConnectionResult acceptVpcPeeringConnection(AcceptVpcPeeringConnectionRequest request) {request = beforeClientExecution(request);return executeAcceptVpcPeeringConnection(request);}
@Override public int size() {return size;}
public JapaneseTokenizerFactory(Map<String,String> args) {super(args);mode = Mode.valueOf(get(args, MODE, JapaneseTokenizer.DEFAULT_MODE.toString()).toUpperCase(Locale.ROOT));userDictionaryPath = args.remove(USER_DICT_PATH);userDictionaryEncoding = args.remove(USER_DICT_ENCODING);discardPunctuation = getBoolean(args, DISCARD_PUNCTUATION, true);discardCompoundToken = getBoolean(args, DISCARD_COMPOUND_TOKEN, true);nbestCost = getInt(args, NBEST_COST, 0);nbestExamples = args.remove(NBEST_EXAMPLES);if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameters: " + args);}}
public void close() throws IOException {synchronized (lock) {if (isClosed()) {return;}Throwable thrown = null;try {flushInternal();} catch (Throwable e) {thrown = e;}buf = null;try {out.close();} catch (Throwable e) {if (thrown == null) {thrown = e;}}out = null;if (thrown != null) {SneakyThrow.sneakyThrow(thrown);}}}
public UnmonitorInstancesRequest(java.util.List<String> instanceIds) {setInstanceIds(instanceIds);}
public void dispatch(IndexChangedListener listener) {listener.onIndexChanged(this);}
public NameRecord getNameRecord(int index) {return _definedNames.get(index);}
public Name(NameRecord nameRecord, int index) {_nameRecord = nameRecord;_index = index;}
public ClaimGameServerResult claimGameServer(ClaimGameServerRequest request) {request = beforeClientExecution(request);return executeClaimGameServer(request);}
public DescribeScalingParametersResult describeScalingParameters(DescribeScalingParametersRequest request) {request = beforeClientExecution(request);return executeDescribeScalingParameters(request);}
public NGramDistance(int size) {this.n = size;}
public DetectDominantLanguageResult detectDominantLanguage(DetectDominantLanguageRequest request) {request = beforeClientExecution(request);return executeDetectDominantLanguage(request);}
public void consume() {if (LA(1) == IntStream.EOF) {throw new IllegalStateException("cannot consume EOF");}lastChar = data[p];   if (p == n-1 && numMarkers==0) {n = 0;p = -1; lastCharBufferStart = lastChar;}p++;currentCharIndex++;sync(1);}
public TokenStream create(TokenStream input) {if (dictionary == null) {return input;}return new DictionaryCompoundWordTokenFilter(input, dictionary, minWordSize, minSubwordSize, maxSubwordSize, onlyLongestMatch);}
