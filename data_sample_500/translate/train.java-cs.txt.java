public String toString() {return "D";}
public Set<URIishField> getRequiredFields() {return Collections.unmodifiableSet(EnumSet.of(URIishField.PATH));}
public String toString(){StringBuilder buffer = new StringBuilder();buffer.append("[VCENTER]\n");buffer.append("    .vcenter        = ").append(getVCenter()).append("\n");buffer.append("[/VCENTER]\n");return buffer.toString();}
public boolean equals(Object obj) {if (this == obj)return true;if (obj == null)return false;if (getClass() != obj.getClass())return false;FlushInfo other = (FlushInfo) obj;if (estimatedSegmentSize != other.estimatedSegmentSize)return false;if (numDocs != other.numDocs)return false;return true;}
public DescribeFileSystemPolicyResult describeFileSystemPolicy(DescribeFileSystemPolicyRequest request) {request = beforeClientExecution(request);return executeDescribeFileSystemPolicy(request);}
public DescribeLoadBalancerTargetGroupsResult describeLoadBalancerTargetGroups(DescribeLoadBalancerTargetGroupsRequest request) {request = beforeClientExecution(request);return executeDescribeLoadBalancerTargetGroups(request);}
public void setParams(String params) {super.setParams(params);traversalSize = (int)Float.parseFloat(params);}
public String toASCIIString() {return format(false, true);}
public NameXPtg getNameXPtg(String name, SheetIdentifier sheet) {int sheetRefIndex = getSheetExtIx(sheet);return _iBook.getNameXPtg(name, sheetRefIndex, _uBook.getUDFFinder());}
public void encode(long[] values, int valuesOffset, byte[] blocks, int blocksOffset, int iterations) {for (int i = 0; i < iterations; ++i) {final long block = encode(values, valuesOffset);valuesOffset += valueCount;blocksOffset = writeLong(block, blocks, blocksOffset);}}
public static String toHex(int value) {StringBuilder sb = new StringBuilder(8);writeHex(sb, value & 0xFFFFFFFFL, 8, "");return sb.toString();}
public static Transport open(URIish uri) throws NotSupportedException, TransportException {for (WeakReference<TransportProtocol> ref : protocols) {TransportProtocol proto = ref.get();if (proto == null) {protocols.remove(ref);continue;}if (proto.canHandle(uri, null, null))return proto.open(uri);}throw new NotSupportedException(MessageFormat.format(JGitText.get().URINotSupported, uri));}
public final int position() {return position;}
public final void write(byte[] b, int off, int len)throws IOException {while (0 < len) {final int n = Math.min(len, BYTES_TO_WRITE_BEFORE_CANCEL_CHECK);count += n;if (checkCancelAt <= count) {if (writeMonitor.isCancelled()) {throw new IOException(JGitText.get().packingCancelledDuringObjectsWriting);}checkCancelAt = count + BYTES_TO_WRITE_BEFORE_CANCEL_CHECK;}out.write(b, off, n);md.update(b, off, n);off += n;len -= n;}}
public CommonToken(int type, String text) {this.type = type;this.channel = DEFAULT_CHANNEL;this.text = text;this.source = EMPTY_SOURCE;}
public void nextBuffer() {if (1+bufferUpto == buffers.length) {int[][] newBuffers = new int[(int) (buffers.length*1.5)][];System.arraycopy(buffers, 0, newBuffers, 0, buffers.length);buffers = newBuffers;}buffer = buffers[1+bufferUpto] = allocator.getIntBlock();bufferUpto++;intUpto = 0;intOffset += INT_BLOCK_SIZE;}
public boolean equals(Object obj) {if (!(obj instanceof PrecedencePredicate)) {return false;}if (this == obj) {return true;}PrecedencePredicate other = (PrecedencePredicate)obj;return this.precedence == other.precedence;}
public PendingTerm(BytesRef term, BlockTermState state) {super(true);this.termBytes = new byte[term.length];System.arraycopy(term.bytes, term.offset, termBytes, 0, term.length);this.state = state;}
public Credential(String keyId, String secret, String securityToken) {this.accessKeyId = keyId;this.accessSecret = secret;this.securityToken = securityToken;this.refreshDate = new Date();}
public static Proxy proxyFor(ProxySelector proxySelector, URL u)throws ConnectException {try {URI uri = new URI(u.getProtocol(), null, u.getHost(), u.getPort(),null, null, null);return proxySelector.select(uri).get(0);} catch (URISyntaxException e) {final ConnectException err;err = new ConnectException(MessageFormat.format(JGitText.get().cannotDetermineProxyFor, u));err.initCause(e);throw err;}}
public synchronized E elementAt(int location) {if (location < elementCount) {return (E) elementData[location];}throw arrayIndexOutOfBoundsException(location, elementCount);}
public MonitorInstancesResult monitorInstances(MonitorInstancesRequest request) {request = beforeClientExecution(request);return executeMonitorInstances(request);}
public int compareTo(RowColKey o) {int cmp = _rowIndex - o._rowIndex;if (cmp != 0) {return cmp;}return _columnIndex - o._columnIndex;}
public void seekExact(long ord) throws IOException {throw new UnsupportedOperationException(getClass().getName()+" does not support seeking");}
public CreateApiMappingResult createApiMapping(CreateApiMappingRequest request) {request = beforeClientExecution(request);return executeCreateApiMapping(request);}
public SetVaultNotificationsResult setVaultNotifications(SetVaultNotificationsRequest request) {request = beforeClientExecution(request);return executeSetVaultNotifications(request);}
public boolean contains(Object o) {return ConcurrentHashMap.this.containsKey(o);}
public void seekExact(BytesRef target, TermState otherState) {if (!target.equals(term)) {state.copyFrom(otherState);term = BytesRef.deepCopyOf(target);seekPending = true;}}
public CreateImageResult createImage(CreateImageRequest request) {request = beforeClientExecution(request);return executeCreateImage(request);}
public PagedBytesDataOutput getDataOutput() {if (frozen) {throw new IllegalStateException("cannot get DataOutput after freeze()");}return new PagedBytesDataOutput();}
public DescribeTaskSetsResult describeTaskSets(DescribeTaskSetsRequest request) {request = beforeClientExecution(request);return executeDescribeTaskSets(request);}
public ResetDBClusterParameterGroupResult resetDBClusterParameterGroup(ResetDBClusterParameterGroupRequest request) {request = beforeClientExecution(request);return executeResetDBClusterParameterGroup(request);}
public static CharBuffer allocate(int capacity) {if (capacity < 0) {throw new IllegalArgumentException();}return new ReadWriteCharArrayBuffer(capacity);}
public synchronized void dropChanges() {pendingDeletes.dropChanges();dropMergingUpdates();}
public void serialize(LittleEndianOutput out) {out.writeShort(field_1_id);out.writeByte(field_4_text.length());if (is16bit) {out.writeByte(0x01);StringUtil.putUnicodeLE(field_4_text, out);} else {out.writeByte(0x00);StringUtil.putCompressedUnicode(field_4_text, out);}}
public void remove() {if (lastReturned == null) {throw new IllegalStateException();}Impl.this.remove(lastReturned.getKey());lastReturned = null;}
public static FuzzySet createSetBasedOnQuality(int maxNumUniqueValues, float desiredMaxSaturation){int setSize=getNearestSetSize(maxNumUniqueValues,desiredMaxSaturation);return new FuzzySet(new FixedBitSet(setSize+1),setSize, hashFunctionForVersion(VERSION_CURRENT));}
public DefineAnalysisSchemeResult defineAnalysisScheme(DefineAnalysisSchemeRequest request) {request = beforeClientExecution(request);return executeDefineAnalysisScheme(request);}
public final boolean isRegistered() {return !canonicalName.startsWith("x-") && !canonicalName.startsWith("X-");}
public ValueEval evaluate(int srcRowIndex, int srcColumnIndex, ValueEval arg0, ValueEval arg1, ValueEval arg2) {try {ValueEval ve = OperandResolver.getSingleValue(arg0, srcRowIndex, srcColumnIndex);final double result = OperandResolver.coerceValueToDouble(ve);if (Double.isNaN(result) || Double.isInfinite(result)) {throw new EvaluationException(ErrorEval.NUM_ERROR);}ve = OperandResolver.getSingleValue(arg2, srcRowIndex, srcColumnIndex);int order_value = OperandResolver.coerceValueToInt(ve);final boolean order;if (order_value==0) {order = true;} else if(order_value==1) {order = false;} else {throw new EvaluationException(ErrorEval.NUM_ERROR);}if (arg1 instanceof RefListEval) {return eval(result, ((RefListEval)arg1), order);}final AreaEval aeRange = convertRangeArg(arg1);return eval(result, aeRange, order);} catch (EvaluationException e) {return e.getErrorEval();}}
public DeleteCustomMetadataResult deleteCustomMetadata(DeleteCustomMetadataRequest request) {request = beforeClientExecution(request);return executeDeleteCustomMetadata(request);}
public PrefixCodedTerms finish() {return new PrefixCodedTerms(output.toBufferList(), size);}
public ObjectId idFor(int type, byte[] data) {return delegate().idFor(type, data);}
public boolean include(TreeWalk walker) {final int n = walker.getTreeCount();if (n == 1) return true;final int m = walker.getRawMode(baseTree);for (int i = 1; i < n; i++)if (walker.getRawMode(i) != m || !walker.idEqual(i, baseTree))return true;return false;}
public void clear() {arrays.clear();}
public String toString() {CellReference crA = new CellReference(getFirstRow(), getFirstColumn());CellReference crB = new CellReference(getLastRow(), getLastColumn());return getClass().getName() + "[" +_evaluator.getSheetNameRange() +'!' +crA.formatAsString() +':' +crB.formatAsString() +"]";}
public QueryParser(CharStream stream) {token_source = new QueryParserTokenManager(stream);token = new Token();jj_ntk = -1;jj_gen = 0;for (int i = 0; i < 10; i++) jj_la1[i] = -1;for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();}
public Boolean booleanValue(String key) {String value = responseMap.get(key);if (null == value || 0 == value.length()) {return null;}return Boolean.valueOf(responseMap.get(key));}
public DescribeRootFoldersResult describeRootFolders(DescribeRootFoldersRequest request) {request = beforeClientExecution(request);return executeDescribeRootFolders(request);}
public String toString(){StringBuilder buffer = new StringBuilder();buffer.append("[PLOTAREA]\n");buffer.append("[/PLOTAREA]\n");return buffer.toString();}
public NamePtg createPtg() {return new NamePtg(_index);}
public static final RevFilter after(Date ts) {return after(ts.getTime());}
public void setRefLogMessage(String msg, boolean appendStatus) {if (msg == null && !appendStatus)disableRefLog();else if (msg == null && appendStatus) {refLogMessage = ""; refLogIncludeResult = true;} else {refLogMessage = msg;refLogIncludeResult = appendStatus;}}
public GetSendStatisticsResult getSendStatistics() {return getSendStatistics(new GetSendStatisticsRequest());}
public DrillSidewaysResult(Facets facets, TopDocs hits) {this.facets = facets;this.hits = hits;}
@Override public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {return IoBridge.read(fd, buffer, byteOffset, byteCount);}
public ByteBuffer putInt(int value) {int newPosition = position + SizeOf.INT;if (newPosition > limit) {throw new BufferOverflowException();}Memory.pokeInt(backingArray, offset + position, value, order);position = newPosition;return this;}
public GetImageLayerRequest() {super("cr", "2016-06-07", "GetImageLayer", "cr");setUriPattern("/repos/[RepoNamespace]/[RepoName]/tags/[Tag]/layers");setMethod(MethodType.GET);}
public DiffCommand diff() {return new DiffCommand(repo);}
public CharSequence toQueryString(EscapeQuerySyntax escapeSyntaxParser) {if (getChildren() == null || getChildren().size() == 0)return "";StringBuilder sb = new StringBuilder();String filler = "";for (QueryNode child : getChildren()) {sb.append(filler).append(child.toQueryString(escapeSyntaxParser));filler = " AND ";}if ((getParent() != null && getParent() instanceof GroupQueryNode)|| isRoot())return sb.toString();elsereturn "( " + sb.toString() + " )";}
public Explanation idfExplain(CollectionStatistics collectionStats, TermStatistics termStats[]) {double idf = 0d; List<Explanation> details = new ArrayList<>();for (final TermStatistics stat : termStats ) {Explanation idfExplain = idfExplain(collectionStats, stat);details.add(idfExplain);idf += idfExplain.getValue().floatValue();}return Explanation.match((float) idf, "idf, sum of:", details);}
public boolean equals(Object other) {if (other == null) {return false;}if (other instanceof BytesRef) {return this.bytesEquals((BytesRef) other);}return false;}
public CreateTableRequest(String tableName, java.util.List<KeySchemaElement> keySchema) {setTableName(tableName);setKeySchema(keySchema);}
public boolean isEnabled(String component) {return false;}
public UpdatePipelineStatusResult updatePipelineStatus(UpdatePipelineStatusRequest request) {request = beforeClientExecution(request);return executeUpdatePipelineStatus(request);}
public final FloatBuffer put(float[] src) {return put(src, 0, src.length);}
public PutRecordResult putRecord(PutRecordRequest request) {request = beforeClientExecution(request);return executePutRecord(request);}
public String toString() {return "TERM: " + brToString(termBytes);}
public Repository open(boolean mustExist) throws IOException {if (mustExist && !isGitRepository(path, fs))throw new RepositoryNotFoundException(path);return new FileRepository(path);}
public static void setInstance(SshSessionFactory newFactory) {if (newFactory != null) {INSTANCE = newFactory;} else {INSTANCE = loadSshSessionFactory();}}
public static String getInflectedFormTranslation(String s) {return inflFormTranslations.get(s);}
@Override public List<E> subList(int start, int end) {synchronized (mutex) {return new SynchronizedList<E>(list.subList(start, end), mutex);}}
public E floor(E e) {return backingMap.floorKey(e);}
public XmlSerializer newSerializer() throws XmlPullParserException {if (serializerClasses == null) {throw new XmlPullParserException("Factory initialization incomplete - has not tried "+classNamesLocation);}if(serializerClasses.size() == 0) {throw new XmlPullParserException("No valid serializer classes found in "+classNamesLocation);}final StringBuilder issues = new StringBuilder ();for (int i = 0; i < serializerClasses.size (); i++) {final Class ppClass = (Class) serializerClasses.get(i);try {final XmlSerializer ser = (XmlSerializer) ppClass.newInstance();return ser;} catch(Exception ex) {issues.append (ppClass.getName () + ": "+ ex.toString ()+"; ");}}throw new XmlPullParserException ("could not create serializer: "+issues);}
@Override public boolean contains(Object object) {if (object instanceof Multiset.Entry) {Multiset.Entry<?> entry = (Multiset.Entry<?>) object;Object element = entry.getElement();int entryCount = entry.getCount();return entryCount > 0 && count(element) == entryCount;}return false;}
public TypeTokenFilterFactory(Map<String,String> args) {super(args);stopTypesFiles = require(args, "types");useWhitelist = getBoolean(args, "useWhitelist", false);if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameters: " + args);}}
public AutomatonQuery(final Term term, Automaton automaton) {this(term, automaton, Operations.DEFAULT_MAX_DETERMINIZED_STATES);}
public AssociateS3ResourcesResult associateS3Resources(AssociateS3ResourcesRequest request) {request = beforeClientExecution(request);return executeAssociateS3Resources(request);}
public CreateHITResult createHIT(CreateHITRequest request) {request = beforeClientExecution(request);return executeCreateHIT(request);}
public double[] toArray() {if (_count < 1) {return EMPTY_DOUBLE_ARRAY;}double[] result = new double[_count];System.arraycopy(_array, 0, result, 0, _count);return result;}
public void write(String s) {reserve(s.length());s.getChars(0,s.length(),buf, len);len +=s.length();}
public String distanceSubQueryNotAllowed() {Iterator<?> sqi = getSubQueriesIterator();while (sqi.hasNext()) {Object leq = sqi.next();if (leq instanceof DistanceSubQuery) {DistanceSubQuery dsq = (DistanceSubQuery) leq;String m = dsq.distanceSubQueryNotAllowed();if (m != null) {return m;}} else {return "Operator " + getOperatorName() + " does not allow subquery " + leq.toString();}}return null; }
public String toString() {return source + " --> " + dest + " " + (char) min + "-" + (char) max;}
public List<String> getDFAStrings() {synchronized (_interp.decisionToDFA) {List<String> s = new ArrayList<String>();for (int d = 0; d < _interp.decisionToDFA.length; d++) {DFA dfa = _interp.decisionToDFA[d];s.add( dfa.toString(getVocabulary()) );}return s;}}
public void fill(BytesRef b, long start) {final int index = (int) (start >> blockBits);final int offset = (int) (start & blockMask);final byte[] block = b.bytes = blocks[index];if ((block[offset] & 128) == 0) {b.length = block[offset];b.offset = offset+1;} else {b.length = ((block[offset] & 0x7f) << 8) | (block[1+offset] & 0xff);b.offset = offset+2;assert b.length > 0;}}
public DomainMetadataResult domainMetadata(DomainMetadataRequest request) {request = beforeClientExecution(request);return executeDomainMetadata(request);}
public DescribeReservedDBInstancesOfferingsResult describeReservedDBInstancesOfferings(DescribeReservedDBInstancesOfferingsRequest request) {request = beforeClientExecution(request);return executeDescribeReservedDBInstancesOfferings(request);}
public int size() {return count;}
public AssociateRepositoryResult associateRepository(AssociateRepositoryRequest request) {request = beforeClientExecution(request);return executeAssociateRepository(request);}
public ObjectProtectRecord clone() {return copy();}
public DeletedRef3DPtg(LittleEndianInput in)  {field_1_index_extern_sheet = in.readUShort();unused1 = in.readInt();}
public DescribeVaultRequest(String accountId, String vaultName) {setAccountId(accountId);setVaultName(vaultName);}
public void rewind() {ns.removeAllElements();ks.setLength(0);cur = root;run();}
public static boolean indexExists(Directory directory) throws IOException {String[] files = directory.listAll();String prefix = IndexFileNames.SEGMENTS + "_";for(String file : files) {if (file.startsWith(prefix)) {return true;}}return false;}
public CreateConfigurationResult createConfiguration(CreateConfigurationRequest request) {request = beforeClientExecution(request);return executeCreateConfiguration(request);}
public void exportRepository(String name, Repository db) {exports.put(nameWithDotGit(name), db);}
public ContentHandler getContentHandler () {return (theContentHandler == this) ? null : theContentHandler;}
public UserInputQueryBuilder(QueryParser parser) {this.unSafeParser = parser;}
public BlameCommand setFilePath(String filePath) {this.path = filePath;return this;}
public void setDirCache(DirCache dc) {this.dircache = dc;implicitDirCache = false;}
public TestDNSAnswerResult testDNSAnswer(TestDNSAnswerRequest request) {request = beforeClientExecution(request);return executeTestDNSAnswer(request);}
public void setTabIdArray(short[] array) {_tabids = array.clone();}
public void println(double d) {println(String.valueOf(d));}
public UpdateContainerInstancesStateResult updateContainerInstancesState(UpdateContainerInstancesStateRequest request) {request = beforeClientExecution(request);return executeUpdateContainerInstancesState(request);}
public PutSchemaFromJsonResult putSchemaFromJson(PutSchemaFromJsonRequest request) {request = beforeClientExecution(request);return executePutSchemaFromJson(request);}
public static boolean isCellInternalDateFormatted(Cell cell) {if (cell == null) {return false;}boolean bDate = false;double d = cell.getNumericCellValue();if ( DateUtil.isValidExcelDate(d) ) {CellStyle style = cell.getCellStyle();int i = style.getDataFormat();bDate = isInternalDateFormat(i);}return bDate;}
public StaticCredentialsProvider(AlibabaCloudCredentials credentials) {this.credentials = credentials;}
public IntervalSet LOOK(ATNState s, ATNState stopState, RuleContext ctx) {IntervalSet r = new IntervalSet();boolean seeThruPreds = true; PredictionContext lookContext = ctx != null ? PredictionContext.fromRuleContext(s.atn, ctx) : null;_LOOK(s, stopState, lookContext,r, new HashSet<ATNConfig>(), new BitSet(), seeThruPreds, true);return r;}
public Lift(boolean changeSkip) {this.changeSkip = changeSkip;}
public CreateNodeResult createNode(CreateNodeRequest request) {request = beforeClientExecution(request);return executeCreateNode(request);}
public static byte[] copyOfRange(byte[] original, int start, int end) {if (start > end) {throw new IllegalArgumentException();}int originalLength = original.length;if (start < 0 || start > originalLength) {throw new ArrayIndexOutOfBoundsException();}int resultLength = end - start;int copyLength = Math.min(resultLength, originalLength - start);byte[] result = new byte[resultLength];System.arraycopy(original, start, result, 0, copyLength);return result;}
public static PathFilter create(String path) {while (path.endsWith("/")) path = path.substring(0, path.length() - 1);if (path.length() == 0)throw new IllegalArgumentException(JGitText.get().emptyPathNotPermitted);return new PathFilter(path);}
public DescribeVolumesResult describeVolumes() {return describeVolumes(new DescribeVolumesRequest());}
public ListTopicsRequest(String nextToken) {setNextToken(nextToken);}
public String toString() {return "G";}
public SortedSet<E> tailSet(E start) {return tailSet(start, true);}
public String getSheetName(int sheetIndex) {return getSheetEvaluator(sheetIndex).getSheetName();}
public void verifyBelongsToWorkbook(HSSFWorkbook wb) {if(wb.getWorkbook() != _workbook) {throw new IllegalArgumentException("This Style does not belong to the supplied Workbook. Are you trying to assign a style from one workbook to the cell of a differnt workbook?");}}
public OffsetLimitTokenFilter(TokenStream input, int offsetLimit) {super(input);this.offsetLimit = offsetLimit;}
public int size() {return mSize;}
public SetDesiredCapacityResult setDesiredCapacity(SetDesiredCapacityRequest request) {request = beforeClientExecution(request);return executeSetDesiredCapacity(request);}
public DeleteVpcResult deleteVpc(DeleteVpcRequest request) {request = beforeClientExecution(request);return executeDeleteVpc(request);}
public static int compareArrayByPrefix(char[] shortArray, int shortIndex,char[] longArray, int longIndex) {if (shortArray == null)return 0;else if (longArray == null)return (shortIndex < shortArray.length) ? 1 : 0;int si = shortIndex, li = longIndex;while (si < shortArray.length && li < longArray.length&& shortArray[si] == longArray[li]) {si++;li++;}if (si == shortArray.length) {return 0;} else {if (li == longArray.length)return 1;elsereturn (shortArray[si] > longArray[li]) ? 1 : -1;}}
public static String stripExtension(String filename) {int idx = filename.indexOf('.');if (idx != -1) {filename = filename.substring(0, idx);}return filename;}
public boolean hasDirectoryEntry() {EmbeddedObjectRefSubRecord subRecord = findObjectRecord();Integer streamId = subRecord.getStreamId();return streamId != null && streamId.intValue() != 0;}
public static int idealShortArraySize(int need) {return idealByteArraySize(need * 2) / 2;}
public CreateLoadBalancerListenersRequest(String loadBalancerName, java.util.List<Listener> listeners) {setLoadBalancerName(loadBalancerName);setListeners(listeners);}
public void setRate(int rate, boolean perMin) {this.rate = rate;this.perMin = perMin;setSequenceName();}
public ModifyInstanceEventStartTimeResult modifyInstanceEventStartTime(ModifyInstanceEventStartTimeRequest request) {request = beforeClientExecution(request);return executeModifyInstanceEventStartTime(request);}
public void remove() {Object[] a = array;int removalIdx = removalIndex;if (modCount != expectedModCount) {throw new ConcurrentModificationException();}if (removalIdx < 0) {throw new IllegalStateException();}System.arraycopy(a, removalIdx + 1, a, removalIdx, remaining);a[--size] = null;  removalIndex = -1;expectedModCount = ++modCount;}
public UpdateWorkteamResult updateWorkteam(UpdateWorkteamRequest request) {request = beforeClientExecution(request);return executeUpdateWorkteam(request);}
public ByteBuffer putLong(long value) {throw new ReadOnlyBufferException();}
public String toFormulaString(String[] operands) {StringBuilder buffer = new StringBuilder();buffer.append( operands[0] );buffer.append("<=");buffer.append( operands[1] );return buffer.toString();}
public void decode(long[] blocks, int blocksOffset, int[] values, int valuesOffset, int iterations) {for (int i = 0; i < iterations; ++i) {final long block = blocks[blocksOffset++];for (int shift = 56; shift >= 0; shift -= 8) {values[valuesOffset++] = (int) ((block >>> shift) & 255);}}}
public GetCheckerIpRangesResult getCheckerIpRanges(GetCheckerIpRangesRequest request) {request = beforeClientExecution(request);return executeGetCheckerIpRanges(request);}
public String toString() {StringBuilder s = new StringBuilder();append(s, oldRef, "CREATE"); s.append(' ');append(s, newRef, "DELETE"); s.append(' ').append(getRefName());s.append(' ').append(getResult());if (getMessage() != null) {s.append(' ').append(getMessage());}return s.toString();}
public FuzzySet downsize(float targetMaxSaturation){int numBitsSet = filter.cardinality();FixedBitSet rightSizedBitSet = filter;int rightSizedBitSetSize = bloomSize;for (int i = 0; i < usableBitSetSizes.length; i++) {int candidateBitsetSize = usableBitSetSizes[i];float candidateSaturation = (float) numBitsSet/ (float) candidateBitsetSize;if (candidateSaturation <= targetMaxSaturation) {rightSizedBitSetSize = candidateBitsetSize;break;}}if (rightSizedBitSetSize < bloomSize) {rightSizedBitSet = new FixedBitSet(rightSizedBitSetSize + 1);int bitIndex = 0;do {bitIndex = filter.nextSetBit(bitIndex);if (bitIndex != DocIdSetIterator.NO_MORE_DOCS) {int downSizedBitIndex = bitIndex & rightSizedBitSetSize;rightSizedBitSet.set(downSizedBitIndex);bitIndex++;}} while ( (bitIndex >= 0)&&(bitIndex<=bloomSize));} else {return null;}return new FuzzySet(rightSizedBitSet,rightSizedBitSetSize, hashFunction);}
public SendMessagesResult sendMessages(SendMessagesRequest request) {request = beforeClientExecution(request);return executeSendMessages(request);}
public GetResolverEndpointResult getResolverEndpoint(GetResolverEndpointRequest request) {request = beforeClientExecution(request);return executeGetResolverEndpoint(request);}
public void write(byte[] buf, int off, int len) throws IOException {try {beginWrite();dst.write(buf, off, len);} catch (InterruptedIOException e) {throw writeTimedOut(e);} finally {endWrite();}}
public boolean isDryRun() {return dryRun;}
public AcceptQualificationRequestResult acceptQualificationRequest(AcceptQualificationRequestRequest request) {request = beforeClientExecution(request);return executeAcceptQualificationRequest(request);}
public void reset() {upto = 0;in.reset();}
public BarRecord(RecordInputStream in) {field_1_barSpace      = in.readShort();field_2_categorySpace = in.readShort();field_3_formatFlags   = in.readShort();}
public int getDecimalExponent() {return _relativeDecimalExponent+EXPONENT_OFFSET;}
public String toString() {return "NO_MERGES"; }
public Query makeQuery(SpatialArgs args) {if(! SpatialOperation.is( args.getOperation(),SpatialOperation.Intersects,SpatialOperation.IsWithin ))throw new UnsupportedSpatialOperation(args.getOperation());Shape shape = args.getShape();if (shape instanceof Rectangle) {Rectangle bbox = (Rectangle) shape;return new ConstantScoreQuery(makeWithin(bbox));} else if (shape instanceof Circle) {Circle circle = (Circle)shape;Rectangle bbox = circle.getBoundingBox();return new DistanceRangeQuery(makeWithin(bbox), makeDistanceValueSource(circle.getCenter()), circle.getRadius());} else {throw new UnsupportedOperationException("Only Rectangles and Circles are currently supported, " +"found [" + shape.getClass() + "]");}}
public FieldDoc(int doc, float score, Object[] fields, int shardIndex) {super(doc, score, shardIndex);this.fields = fields;}
public SimpleBoundaryScanner( int maxScan, Set<Character> boundaryChars ){this.maxScan = maxScan;this.boundaryChars = boundaryChars;}
public PutLifecycleHookResult putLifecycleHook(PutLifecycleHookRequest request) {request = beforeClientExecution(request);return executePutLifecycleHook(request);}
public ListSignalingChannelsResult listSignalingChannels(ListSignalingChannelsRequest request) {request = beforeClientExecution(request);return executeListSignalingChannels(request);}
public LengthFilter create(TokenStream input) {final LengthFilter filter = new LengthFilter(input,min,max);return filter;}
public DisassociateMembershipResult disassociateMembership(DisassociateMembershipRequest request) {request = beforeClientExecution(request);return executeDisassociateMembership(request);}
public ValueEval evaluate(int srcRowIndex, int srcColumnIndex, ValueEval numberVE) {int number;try {number = OperandResolver.coerceValueToInt(numberVE);} catch (EvaluationException e) {return ErrorEval.VALUE_INVALID;}if (number < 0) {return ErrorEval.NUM_ERROR;}return new NumberEval(factorial(number).longValue());}
public UpdateFleetPortSettingsResult updateFleetPortSettings(UpdateFleetPortSettingsRequest request) {request = beforeClientExecution(request);return executeUpdateFleetPortSettings(request);}
public E poll() {return size == 0 ? null : removeFirst();}
public int getLastInternalSheetIndexForExtIndex(int extRefIndex) {if (extRefIndex >= _externSheetRecord.getNumOfRefs() || extRefIndex < 0) {return -1;}return _externSheetRecord.getLastSheetIndexFromRefIndex(extRefIndex);}
public CharBlockArray append(CharSequence chars, int start, int length) {int end = start + length;for (int i = start; i < end; i++) {append(chars.charAt(i));}return this;}
public TagCommand setForceUpdate(boolean forceUpdate) {this.forceUpdate = forceUpdate;return this;}
public ValueEval getRefEval(int rowIndex, int columnIndex) {SheetRangeEvaluator sre = getRefEvaluatorForCurrentSheet();return new LazyRefEval(rowIndex, columnIndex, sre);}
public void set(E object) {iterator.set(object);}
public GetInstancePortStatesResult getInstancePortStates(GetInstancePortStatesRequest request) {request = beforeClientExecution(request);return executeGetInstancePortStates(request);}
public ModifyImageAttributeRequest(String imageId, String attribute) {setImageId(imageId);setAttribute(attribute);}
public void notifySetFormula(Cell cell) {_bookEvaluator.notifyUpdateCell(new HSSFEvaluationCell((HSSFCell)cell));}
public void dumpDrawingGroupRecords(boolean fat) {DrawingGroupRecord r = (DrawingGroupRecord) workbook.findFirstRecordBySid( DrawingGroupRecord.sid );if (r == null) {return;}r.decode();List<EscherRecord> escherRecords = r.getEscherRecords();PrintWriter w = new PrintWriter(new OutputStreamWriter(System.out, Charset.defaultCharset()));for (EscherRecord escherRecord : escherRecords) {if (fat) {System.out.println(escherRecord);} else {escherRecord.display(w, 0);}}w.flush();}
public DeleteTagsRequest(java.util.List<String> resources) {setResources(resources);}
public static FileKey lenient(File directory, FS fs) {final File gitdir = resolve(directory, fs);return new FileKey(gitdir != null ? gitdir : directory, fs);}
public ObjectLoader open(DiffEntry.Side side, DiffEntry ent)throws IOException {switch (side) {case OLD:return oldSource.open(ent.oldPath, ent.oldId.toObjectId());case NEW:return newSource.open(ent.newPath, ent.newId.toObjectId());default:throw new IllegalArgumentException();}}
public int getRenameScore() {return outCandidate.renameScore;}
public StopTrainingEntityRecognizerResult stopTrainingEntityRecognizer(StopTrainingEntityRecognizerRequest request) {request = beforeClientExecution(request);return executeStopTrainingEntityRecognizer(request);}
public HashMap() {table = (HashMapEntry<K, V>[]) EMPTY_TABLE;threshold = -1; }
public int peekNextSid() {if(!hasNext()) {return -1;}return _list.get(_nextIndex).getSid();}
public int codePointBefore(int index) {if (index < 1 || index > count) {throw indexAndLength(index);}return Character.codePointBefore(value, index);}
public BatchGetDeploymentTargetsResult batchGetDeploymentTargets(BatchGetDeploymentTargetsRequest request) {request = beforeClientExecution(request);return executeBatchGetDeploymentTargets(request);}
public int defineDecisionState(DecisionState s) {decisionToState.add(s);s.decision = decisionToState.size()-1;return s.decision;}
public DescribeReservedNodesResult describeReservedNodes() {return describeReservedNodes(new DescribeReservedNodesRequest());}
public List<String> getUntrackedFolders() {LinkedList<String> ret = new LinkedList<>(untrackedFolders);if (!untrackedParentFolders.isEmpty()) {String toBeAdded = untrackedParentFolders.getLast();while (!ret.isEmpty() && ret.getLast().startsWith(toBeAdded))ret.removeLast();ret.addLast(toBeAdded);}return ret;}
public String toFormulaString(FormulaRenderingWorkbook book) {return ExternSheetNameResolver.prependSheetName(book, field_1_index_extern_sheet, FormulaError.REF.getString());}
public Object[] toArray() {synchronized (Hashtable.this) {return super.toArray();}}
public DeleteTrafficPolicyInstanceResult deleteTrafficPolicyInstance(DeleteTrafficPolicyInstanceRequest request) {request = beforeClientExecution(request);return executeDeleteTrafficPolicyInstance(request);}
public CreateHITTypeResult createHITType(CreateHITTypeRequest request) {request = beforeClientExecution(request);return executeCreateHITType(request);}
public DeregisterTypeResult deregisterType(DeregisterTypeRequest request) {request = beforeClientExecution(request);return executeDeregisterType(request);}
public FeatProtection(RecordInputStream in) {fSD = in.readInt();passwordVerifier = in.readInt();title = StringUtil.readUnicodeString(in);securityDescriptor = in.readRemainder();}
public DescribeReservedCacheNodesResult describeReservedCacheNodes(DescribeReservedCacheNodesRequest request) {request = beforeClientExecution(request);return executeDescribeReservedCacheNodes(request);}
public DescribeSubnetsResult describeSubnets(DescribeSubnetsRequest request) {request = beforeClientExecution(request);return executeDescribeSubnets(request);}
public ClusterSecurityGroup revokeClusterSecurityGroupIngress(RevokeClusterSecurityGroupIngressRequest request) {request = beforeClientExecution(request);return executeRevokeClusterSecurityGroupIngress(request);}
public NorwegianLightStemFilterFactory(Map<String,String> args) {super(args);String variant = get(args, "variant");if (variant == null || "nb".equals(variant)) {flags = BOKMAAL;} else if ("nn".equals(variant)) {flags = NYNORSK;} else if ("no".equals(variant)) {flags = BOKMAAL | NYNORSK;} else {throw new IllegalArgumentException("invalid variant: " + variant);}if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameters: " + args);}}
public SendUsersMessagesResult sendUsersMessages(SendUsersMessagesRequest request) {request = beforeClientExecution(request);return executeSendUsersMessages(request);}
public static double pv(double r, double n, double y, double f, boolean t) {double retval = 0;if (r == 0) {retval = -1*((n*y)+f);}else {double r1 = r + 1;retval =(( ( 1 - Math.pow(r1, n) ) / r ) * (t ? r1 : 1)  * y - f)/Math.pow(r1, n);}return retval;}
public DictionaryCompoundWordTokenFilterFactory(Map<String, String> args) {super(args);dictFile = require(args, "dictionary");minWordSize = getInt(args, "minWordSize", CompoundWordTokenFilterBase.DEFAULT_MIN_WORD_SIZE);minSubwordSize = getInt(args, "minSubwordSize", CompoundWordTokenFilterBase.DEFAULT_MIN_SUBWORD_SIZE);maxSubwordSize = getInt(args, "maxSubwordSize", CompoundWordTokenFilterBase.DEFAULT_MAX_SUBWORD_SIZE);onlyLongestMatch = getBoolean(args, "onlyLongestMatch", true);if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameters: " + args);}}
public void reset(byte[] bytes, int offset, int len) {this.bytes = bytes;pos = offset;limit = offset + len;}
public DeleteQueryLoggingConfigResult deleteQueryLoggingConfig(DeleteQueryLoggingConfigRequest request) {request = beforeClientExecution(request);return executeDeleteQueryLoggingConfig(request);}
public StartDocumentTextDetectionResult startDocumentTextDetection(StartDocumentTextDetectionRequest request) {request = beforeClientExecution(request);return executeStartDocumentTextDetection(request);}
public TokenStream create(TokenStream input) {if (words == null) {return input;} else {final TokenStream filter = new KeepWordFilter(input, words);return filter;}}
public CreateStreamingDistributionWithTagsResult createStreamingDistributionWithTags(CreateStreamingDistributionWithTagsRequest request) {request = beforeClientExecution(request);return executeCreateStreamingDistributionWithTags(request);}
public ThrowingPrintWriter(Writer out) {this.out = out;LF = AccessController.doPrivileged((PrivilegedAction<String>) () -> SystemReader.getInstance().getProperty("line.separator") );}
public TokenStream newSinkTokenStream() {return new SinkTokenStream(this.cloneAttributes(), cachedStates);}
public final String toString() {return toString("");}
public CreateVpnGatewayResult createVpnGateway(CreateVpnGatewayRequest request) {request = beforeClientExecution(request);return executeCreateVpnGateway(request);}
public boolean isRetainBody() {return retainBody;}
public CharVector(char[] a, int capacity) {if (capacity > 0) {blockSize = capacity;} else {blockSize = DEFAULT_BLOCK_SIZE;}array = a;n = a.length;}
public final List<String> getFooterLines(FooterKey keyName) {final List<FooterLine> src = getFooterLines();if (src.isEmpty())return Collections.emptyList();final ArrayList<String> r = new ArrayList<>(src.size());for (FooterLine f : src) {if (f.matches(keyName))r.add(f.getValue());}return r;}
public Object[][] getTokenArrayValues() {if (_arrayValues == null) {throw new IllegalStateException("array values not read yet");}Object[][] result = new Object[_nRows][_nColumns];for (int r = 0; r < _nRows; r++) {Object[] rowData = result[r];for (int c = 0; c < _nColumns; c++) {rowData[c] = _arrayValues[getValueIndex(c, r)];}}return result;}
public StringBuilder insert(int offset, float f) {insert0(offset, Float.toString(f));return this;}
public void decode(byte[] blocks, int blocksOffset, int[] values, int valuesOffset, int iterations) {for (int j = 0; j < iterations; ++j) {final byte block = blocks[blocksOffset++];values[valuesOffset++] = (block >>> 6) & 3;values[valuesOffset++] = (block >>> 4) & 3;values[valuesOffset++] = (block >>> 2) & 3;values[valuesOffset++] = block & 3;}}
public static TokenizerFactory forName(String name, Map<String,String> args) {return loader.newInstance(name, args);}
public String toString() {return markedUpText.subSequence(textStartPos, textEndPos).toString();}
public FormatAndBits(Format format, int bitsPerValue) {this.format = format;this.bitsPerValue = bitsPerValue;}
public void serialize(LittleEndianOutput out) {out.writeByte(field_1_horizontalAlignment);out.writeByte(field_2_verticalAlignment);out.writeShort(field_3_displayMode);out.writeInt(field_4_rgbColor);out.writeInt(field_5_x);out.writeInt(field_6_y);out.writeInt(field_7_width);out.writeInt(field_8_height);out.writeShort(field_9_options1);out.writeShort(field_10_indexOfColorValue);out.writeShort(field_11_options2);out.writeShort(field_12_textRotation);}
public ValueEval evaluate(int srcRowIndex, int srcColumnIndex, ValueEval arg0) {double result;if (arg0 instanceof RefEval) {result = CountUtils.countMatchingCellsInRef((RefEval) arg0, predicate);} else if (arg0 instanceof ThreeDEval) {result = CountUtils.countMatchingCellsInArea((ThreeDEval) arg0, predicate);} else {throw new IllegalArgumentException("Bad range arg type (" + arg0.getClass().getName() + ")");}return new NumberEval(result);}
public long getEntryLastModified() {return current().getLastModified();}
public boolean equals(Object obj) {if (!(obj instanceof Loc)) {return false;}Loc other = (Loc) obj;return _bookSheetColumn == other._bookSheetColumn && _rowIndex == other._rowIndex;}
public final void readFully(byte[] dst, int offset, int byteCount) throws IOException {Streams.readFully(in, dst, offset, byteCount);}
public DBInstance createDBInstanceReadReplica(CreateDBInstanceReadReplicaRequest request) {request = beforeClientExecution(request);return executeCreateDBInstanceReadReplica(request);}
public List<FastIgnoreRule> getRules() {return Collections.unmodifiableList(rules);}
public void setBytesValue(BytesRef value) {if (!(fieldsData instanceof BytesRef)) {throw new IllegalArgumentException("cannot change value type from " + fieldsData.getClass().getSimpleName() + " to BytesRef");}if (type.indexOptions() != IndexOptions.NONE) {throw new IllegalArgumentException("cannot set a BytesRef value on an indexed field");}if (value == null) {throw new IllegalArgumentException("value must not be null");}fieldsData = value;}
public Object merge(Object first, Object second) {List<T> outputList = new ArrayList<>();if (!(first instanceof List)) {outputList.add((T) first);} else {outputList.addAll((List<T>) first);}if (!(second instanceof List)) {outputList.add((T) second);} else {outputList.addAll((List<T>) second);}return outputList;}
public UpdateApplicationResult updateApplication(UpdateApplicationRequest request) {request = beforeClientExecution(request);return executeUpdateApplication(request);}
public UpdateDocumentationPartResult updateDocumentationPart(UpdateDocumentationPartRequest request) {request = beforeClientExecution(request);return executeUpdateDocumentationPart(request);}
public void remove() {if (lastEntryReturned == null)throw new IllegalStateException();if (modCount != expectedModCount)throw new ConcurrentModificationException();Hashtable.this.remove(lastEntryReturned.key);lastEntryReturned = null;expectedModCount = modCount;}
public GetMetricStatisticsResult getMetricStatistics(GetMetricStatisticsRequest request) {request = beforeClientExecution(request);return executeGetMetricStatistics(request);}
public final void writeLong(long val) throws IOException {Memory.pokeLong(scratch, 0, val, ByteOrder.BIG_ENDIAN);write(scratch, 0, SizeOf.LONG);}
public void assume(RevCommit c) {if (c != null)assume.add(c);}
public int addConditionalFormatting( ConditionalFormatting cf ) {return addConditionalFormatting((HSSFConditionalFormatting)cf);}
public BlameCommand blame() {return new BlameCommand(repo);}
public boolean equals(Object obj) {if (obj == this) {return true;}else if (!(obj instanceof LexerCustomAction)) {return false;}LexerCustomAction other = (LexerCustomAction)obj;return ruleIndex == other.ruleIndex&& actionIndex == other.actionIndex;}
public LinkedDataRecord getDataSecondaryCategoryLabels() {return dataSecondaryCategoryLabels;}
public SimpleHTMLFormatter(String preTag, String postTag) {this.preTag = preTag;this.postTag = postTag;}
public String toString() {StringBuilder sb = new StringBuilder("[ArrayPtg]\n");sb.append("nRows = ").append(getRowCount()).append("\n");sb.append("nCols = ").append(getColumnCount()).append("\n");if (_arrayValues == null) {sb.append("  #values#uninitialised#\n");} else {sb.append("  ").append(toFormulaString());}return sb.toString();}
public void serialize(LittleEndianOutput out) {out.writeShort(field_1_formatIndex);}
public IntBuffer get(int[] dst, int dstOffset, int intCount) {byteBuffer.limit(limit * SizeOf.INT);byteBuffer.position(position * SizeOf.INT);if (byteBuffer instanceof DirectByteBuffer) {((DirectByteBuffer) byteBuffer).get(dst, dstOffset, intCount);} else {((HeapByteBuffer) byteBuffer).get(dst, dstOffset, intCount);}this.position += intCount;return this;}
public static RevFilter has(RevFlag a) {final RevFlagSet s = new RevFlagSet();s.add(a);return new HasAll(s);}
public ThaiTokenizerFactory(Map<String,String> args) {super(args);if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameters: " + args);}}
public NameXPxg(int externalWorkbookNumber, String sheetName, String nameName) {this.externalWorkbookNumber = externalWorkbookNumber;this.sheetName = sheetName;this.nameName = nameName;}
public CreatePlacementGroupRequest(String groupName, PlacementStrategy strategy) {setGroupName(groupName);setStrategy(strategy.toString());}
public String toString() {switch (state) {case SET:return key;case UNSET:return "-" + key; case UNSPECIFIED:return "!" + key; case CUSTOM:default:return key + "=" + value; }}
public GetCampaignVersionResult getCampaignVersion(GetCampaignVersionRequest request) {request = beforeClientExecution(request);return executeGetCampaignVersion(request);}
public CreateBranchCommand branchCreate() {return new CreateBranchCommand(repo);}
public static final RevFilter before(long ts) {return new Before(ts);}
public ValueEval getArea3DEval(Area3DPxg aptg) {SheetRangeEvaluator sre = createExternSheetRefEvaluator(aptg.getSheetName(), aptg.getLastSheetName(), aptg.getExternalWorkbookNumber());return new LazyAreaEval(aptg.getFirstRow(), aptg.getFirstColumn(),aptg.getLastRow(), aptg.getLastColumn(), sre);}
public void setDeltaSearchWindowSize(int objectCount) {if (objectCount <= 2)setDeltaCompress(false);elsedeltaSearchWindowSize = objectCount;}
public CharBuffer put(int index, char c) {checkIndex(index);backingArray[offset + index] = c;return this;}
public StringWriter append(CharSequence csq) {if (csq == null) {csq = "null";}write(csq.toString());return this;}
public void setDoubleValue(double value) {if (!(fieldsData instanceof Double)) {throw new IllegalArgumentException("cannot change value type from " + fieldsData.getClass().getSimpleName() + " to Double");}fieldsData = Double.valueOf(value);}
public OpenNLPLemmatizerFilter create(TokenStream in) {try {NLPLemmatizerOp lemmatizerOp = OpenNLPOpsFactory.getLemmatizer(dictionaryFile, lemmatizerModelFile);return new OpenNLPLemmatizerFilter(in, lemmatizerOp);} catch (IOException e) {throw new RuntimeException(e);}}
public int getBigBlockSize() {return bigBlockSize;}
public CompleteLifecycleActionResult completeLifecycleAction(CompleteLifecycleActionRequest request) {request = beforeClientExecution(request);return executeCompleteLifecycleAction(request);}
public ValueEval evaluate(int srcRowIndex, int srcColumnIndex, ValueEval numberVE, ValueEval formVE) {int number = 0;try {ValueEval ve = OperandResolver.getSingleValue(numberVE, srcRowIndex, srcColumnIndex);number = OperandResolver.coerceValueToInt(ve);} catch (EvaluationException e) {return ErrorEval.VALUE_INVALID;}if (number < 0) {return ErrorEval.VALUE_INVALID;}if (number > 3999) {return ErrorEval.VALUE_INVALID;}if (number == 0) {return new StringEval("");}int form = 0;try {ValueEval ve = OperandResolver.getSingleValue(formVE, srcRowIndex, srcColumnIndex);form = OperandResolver.coerceValueToInt(ve);} catch (EvaluationException e) {return ErrorEval.NUM_ERROR;}if (form > 4 || form < 0) {return ErrorEval.VALUE_INVALID;}String result = this.integerToRoman(number);if (form == 0) {return new StringEval(result);}return new StringEval(makeConcise(result, form));}
public int getIndex() {return offset;}
public GetRelationalDatabaseSnapshotsResult getRelationalDatabaseSnapshots(GetRelationalDatabaseSnapshotsRequest request) {request = beforeClientExecution(request);return executeGetRelationalDatabaseSnapshots(request);}
public void decode(long[] blocks, int blocksOffset, long[] values, int valuesOffset, int iterations) {for (int i = 0; i < iterations; ++i) {final long block = blocks[blocksOffset++];for (int shift = 62; shift >= 0; shift -= 2) {values[valuesOffset++] = (block >>> shift) & 3;}}}
public SaveRecalcRecord(RecordInputStream in) {field_1_recalc = in.readShort();}
public Credential(String keyId, String secret) {this.accessKeyId = keyId;this.accessSecret = secret;this.refreshDate = new Date();}
public ListJobsResult listJobs() {return listJobs(new ListJobsRequest());}
public ValueEval evaluate(int srcRowIndex, int srcColumnIndex, ValueEval arg0) {ValueEval arg = arg0;if (arg instanceof RefEval) {RefEval re = (RefEval)arg;arg = re.getInnerValueEval(re.getFirstSheetIndex());} else if (arg instanceof AreaEval) {arg = ((AreaEval) arg).getRelativeValue(0, 0);}if (arg instanceof StringEval) {return arg;}if (arg instanceof ErrorEval) {return arg;}return StringEval.EMPTY_INSTANCE;}
public DelegationSet(java.util.List<String> nameServers) {setNameServers(nameServers);}
public Trie reduce(Reduce by) {return by.optimize(this);}
public boolean isSupportedType(final int variantType) {for (int st : SUPPORTED_TYPES) {if (variantType == st) {return true;}}return false;}
public TokenStream create(TokenStream input) {return new SwedishLightStemFilter(input);}
public String toString() {return getClass().getSimpleName() + '@' + Integer.toHexString(hashCode());}
public static int getEncodedSize(Ptg[] ptgs) {int result = 0;for (Ptg ptg : ptgs) {result += ptg.getSize();}return result;}
public String apiVersion() {return this.apiVersion;}
public void cloneStyleFrom(FontRecord source) {field_1_font_height         = source.field_1_font_height;field_2_attributes          = source.field_2_attributes;field_3_color_palette_index = source.field_3_color_palette_index;field_4_bold_weight         = source.field_4_bold_weight;field_5_super_sub_script    = source.field_5_super_sub_script;field_6_underline           = source.field_6_underline;field_7_family              = source.field_7_family;field_8_charset             = source.field_8_charset;field_9_zero                = source.field_9_zero;field_11_font_name          = source.field_11_font_name;}
public CreateAdditionalAssignmentsForHITResult createAdditionalAssignmentsForHIT(CreateAdditionalAssignmentsForHITRequest request) {request = beforeClientExecution(request);return executeCreateAdditionalAssignmentsForHIT(request);}
public boolean equals(Object o) {if (o instanceof AbbreviatedObjectId) {final AbbreviatedObjectId b = (AbbreviatedObjectId) o;return nibbles == b.nibbles && w1 == b.w1 && w2 == b.w2&& w3 == b.w3 && w4 == b.w4 && w5 == b.w5;}return false;}
public GetRepoListRequest() {super("cr", "2016-06-07", "GetRepoList", "cr");setUriPattern("/repos");setMethod(MethodType.GET);}
public DeleteSpotDatafeedSubscriptionResult deleteSpotDatafeedSubscription() {return deleteSpotDatafeedSubscription(new DeleteSpotDatafeedSubscriptionRequest());}
public boolean isSupported(int bitsPerValue) {return bitsPerValue >= 1 && bitsPerValue <= 64;}
public UpdateApplicationVersionRequest(String applicationName, String versionLabel) {setApplicationName(applicationName);setVersionLabel(versionLabel);}
public RebaseCommand setUpstream(AnyObjectId upstream) {try {this.upstreamCommit = walk.parseCommit(upstream);this.upstreamCommitName = upstream.name();} catch (IOException e) {throw new JGitInternalException(MessageFormat.format(JGitText.get().couldNotReadObjectWhileParsingCommit,upstream.name()), e);}return this;}
public char next() {if (offset >= (end - 1)) {offset = end;return DONE;}return string.charAt(++offset);}
public long getOffset() {return offset;}
public String toString() {String inv = invert ? "!" : "";return getClass().getSimpleName()+"["+inv+nodeName+"]";}
public TagMeetingResult tagMeeting(TagMeetingRequest request) {request = beforeClientExecution(request);return executeTagMeeting(request);}
public HSSFShape(EscherContainerRecord spContainer, ObjRecord objRecord) {this._escherContainer = spContainer;this._objRecord = objRecord;this._optRecord = spContainer.getChildById(EscherOptRecord.RECORD_ID);this.anchor = HSSFAnchor.createAnchorFromEscher(spContainer);}
public Matcher region(int start, int end) {return reset(input, start, end);}
public GetVoiceConnectorTerminationHealthResult getVoiceConnectorTerminationHealth(GetVoiceConnectorTerminationHealthRequest request) {request = beforeClientExecution(request);return executeGetVoiceConnectorTerminationHealth(request);}
public void serialize(LittleEndianOutput out) {out.writeShort(field_1_precision);}
public Principal(String accountId) {this("AWS", accountId);if (accountId == null) {throw new IllegalArgumentException("Null AWS account ID specified");}}
public AddImageRequest() {super("ImageSearch", "2019-03-25", "AddImage", "imagesearch");setUriPattern("/v2/image/add");setMethod(MethodType.POST);}
public void fromObjectId(AnyObjectId src) {this.w1 = src.w1;this.w2 = src.w2;this.w3 = src.w3;this.w4 = src.w4;this.w5 = src.w5;}
public static String getText(int errorCode) {if(FormulaError.isValidCode(errorCode)) {return FormulaError.forInt(errorCode).getString();}return "~non~std~err(" + errorCode + ")~";}
public void setBaseline() {setBaseline(clock.get());}
public static void clearModels() {sentenceModels.clear();tokenizerModels.clear();posTaggerModels.clear();chunkerModels.clear();nerModels.clear();lemmaDictionaries.clear();}
public URIish setPort(int n) {final URIish r = new URIish(this);r.port = n > 0 ? n : -1;return r;}
public void decode(byte[] blocks, int blocksOffset, long[] values, int valuesOffset, int iterations) {for (int j = 0; j < iterations; ++j) {final byte block = blocks[blocksOffset++];values[valuesOffset++] = (block >>> 4) & 15;values[valuesOffset++] = block & 15;}}
public boolean markSupported() {return in.markSupported();}
public ValueEval evaluate(int srcRowIndex, int srcColumnIndex,ValueEval arg0, ValueEval arg1) {double result;try {ValueVector vvY = createValueVector(arg0);ValueVector vvX = createValueVector(arg1);int size = vvX.getSize();if (size == 0 || vvY.getSize() != size) {return ErrorEval.NA;}result = evaluateInternal(vvX, vvY, size);} catch (EvaluationException e) {return e.getErrorEval();}if (Double.isNaN(result) || Double.isInfinite(result)) {return ErrorEval.NUM_ERROR;}return new NumberEval(result);}
public int compareTo(String version) {long gen = Long.parseLong(version, RADIX);long commitGen = commit.getGeneration();return commitGen < gen ? -1 : (commitGen > gen ? 1 : 0);}
public String toString() {return "weight(" + TermQuery.this + ")";}
public BatchGetDeploymentGroupsResult batchGetDeploymentGroups(BatchGetDeploymentGroupsRequest request) {request = beforeClientExecution(request);return executeBatchGetDeploymentGroups(request);}
public TestInvokeAuthorizerResult testInvokeAuthorizer(TestInvokeAuthorizerRequest request) {request = beforeClientExecution(request);return executeTestInvokeAuthorizer(request);}
public RevTree parseTree(AnyObjectId id)throws MissingObjectException, IncorrectObjectTypeException,IOException {RevObject c = peel(parseAny(id));final RevTree t;if (c instanceof RevCommit)t = ((RevCommit) c).getTree();else if (!(c instanceof RevTree))throw new IncorrectObjectTypeException(id.toObjectId(),Constants.TYPE_TREE);elset = (RevTree) c;parseHeaders(t);return t;}
public void parseLine(DocData docData, String line) {String[] parts = line.split("\\t", 7);docData.setID(Integer.parseInt(parts[0]));docData.setName(parts[1]);String latitude = parts[4];String longitude = parts[5];docData.setBody("POINT("+longitude+" "+latitude+")");}
public EnableEbsEncryptionByDefaultResult enableEbsEncryptionByDefault(EnableEbsEncryptionByDefaultRequest request) {request = beforeClientExecution(request);return executeEnableEbsEncryptionByDefault(request);}
public boolean equals(Object obj) {if ( this==obj ) return true;if ( !(obj instanceof AND) ) return false;AND other = (AND)obj;return Arrays.equals(this.opnds, other.opnds);}
public SigningCertificate(String userName, String certificateId, String certificateBody, StatusType status) {setUserName(userName);setCertificateId(certificateId);setCertificateBody(certificateBody);setStatus(status.toString());}
public int[] init() {final int[] ord = super.init();boost = new float[ArrayUtil.oversize(ord.length, Float.BYTES)];termState = new TermStates[ArrayUtil.oversize(ord.length, RamUsageEstimator.NUM_BYTES_OBJECT_REF)];assert termState.length >= ord.length && boost.length >= ord.length;return ord;}
public ValueEval evaluate(int srcRowIndex, int srcColumnIndex, ValueEval arg0) {int rnum;if (arg0 instanceof AreaEval) {rnum = ((AreaEval) arg0).getFirstColumn();} else if (arg0 instanceof RefEval) {rnum = ((RefEval) arg0).getColumn();} else {return ErrorEval.VALUE_INVALID;}return new NumberEval(rnum + 1);}
public String getRawFragment() {return fragment;}
public ValueEval evaluate(int srcRowIndex, int srcColumnIndex, ValueEval real_num, ValueEval i_num) {return this.evaluate(srcRowIndex, srcColumnIndex, real_num, i_num, new StringEval(DEFAULT_SUFFIX));}
public PutAccountDedicatedIpWarmupAttributesResult putAccountDedicatedIpWarmupAttributes(PutAccountDedicatedIpWarmupAttributesRequest request) {request = beforeClientExecution(request);return executePutAccountDedicatedIpWarmupAttributes(request);}
public void add(int forwardId, int backwardId, int cost) {int offset = (backwardId * forwardSize + forwardId) * 2;costs.putShort(offset, (short) cost);}
public DisassociateIpGroupsResult disassociateIpGroups(DisassociateIpGroupsRequest request) {request = beforeClientExecution(request);return executeDisassociateIpGroups(request);}
public DeleteGatewayGroupResult deleteGatewayGroup(DeleteGatewayGroupRequest request) {request = beforeClientExecution(request);return executeDeleteGatewayGroup(request);}
public ChartFormatRecord(RecordInputStream in) {field1_x_position = in.readInt();field2_y_position = in.readInt();field3_width = in.readInt();field4_height = in.readInt();field5_grbit = in.readUShort();field6_unknown = in.readUShort();}
public GetDocumentationVersionResult getDocumentationVersion(GetDocumentationVersionRequest request) {request = beforeClientExecution(request);return executeGetDocumentationVersion(request);}
public int stem(char s[], int len) {assert s.length >= len + 1 : "this stemmer requires an oversized array of at least 1";len = plural.apply(s, len);len = unification.apply(s, len);len = adverb.apply(s, len);int oldlen;do {oldlen = len;len = augmentative.apply(s, len);} while (len != oldlen);oldlen = len;len = noun.apply(s, len);if (len == oldlen) { len = verb.apply(s, len);}len = vowel.apply(s, len);for (int i = 0; i < len; i++)switch(s[i]) {case 'á': s[i] = 'a'; break;case 'é':case 'ê': s[i] = 'e'; break;case 'í': s[i] = 'i'; break;case 'ó': s[i] = 'o'; break;case 'ú': s[i] = 'u'; break;}return len;}
public static void fill(float[] array, float value) {for (int i = 0; i < array.length; i++) {array[i] = value;}}
public ByteBuffer putInt(int index, int value) {checkIndex(index, SizeOf.INT);Memory.pokeInt(backingArray, offset + index, value, order);return this;}
public void print(long lnum) {print(String.valueOf(lnum));}
@Override public E remove(int location) {synchronized (mutex) {return list.remove(location);}}
public GetMetricWidgetImageResult getMetricWidgetImage(GetMetricWidgetImageRequest request) {request = beforeClientExecution(request);return executeGetMetricWidgetImage(request);}
public SeekStatus seekCeil(BytesRef term) {throw new UnsupportedOperationException();}
public List<String> getModifiedList() {return modifiedList;}
public SearchRoomsResult searchRooms(SearchRoomsRequest request) {request = beforeClientExecution(request);return executeSearchRooms(request);}
public short getShortRawValue(final short holder){return ( short ) getRawValue(holder);}
public DescribeRulesPackagesResult describeRulesPackages(DescribeRulesPackagesRequest request) {request = beforeClientExecution(request);return executeDescribeRulesPackages(request);}
public ListFargateProfilesResult listFargateProfiles(ListFargateProfilesRequest request) {request = beforeClientExecution(request);return executeListFargateProfiles(request);}
public QueryPhraseMap getTermMap( String term ){return subMap.get( term );}
public String getRawPath() {return rawPath;}
static public double fv(double r, int nper, double c, double pv) {return fv(r, nper, c, pv, 0);}
public int getPositionIncrementGap(String fieldName) {return getWrappedAnalyzer(fieldName).getPositionIncrementGap(fieldName);}
public UpdateUserPhoneConfigResult updateUserPhoneConfig(UpdateUserPhoneConfigRequest request) {request = beforeClientExecution(request);return executeUpdateUserPhoneConfig(request);}
public void setTreeFilter(TreeFilter newFilter) {assertNotStarted();treeFilter = newFilter != null ? newFilter : TreeFilter.ALL;}
public GetGatewayResult getGateway(GetGatewayRequest request) {request = beforeClientExecution(request);return executeGetGateway(request);}
public TokenStream create(TokenStream input) {return new GermanLightStemFilter(input);}
public Builder() {this(false);}
public CharArrayReader(char[] buf, int offset, int length) {if (offset < 0 || offset > buf.length || length < 0 || offset + length < 0) {throw new IllegalArgumentException();}this.buf = buf;this.pos = offset;this.markedPos = offset;int bufferLength = buf.length;this.count = offset + length < bufferLength ? length : bufferLength;}
public void addBreak(int main, int subFrom, int subTo) {Integer key = Integer.valueOf(main);Break region = _breakMap.get(key);if(region == null) {region = new Break(main, subFrom, subTo);_breakMap.put(key, region);_breaks.add(region);} else {region.main = main;region.subFrom = subFrom;region.subTo = subTo;}}
public Object subtract(Object object, Object inc) {return outputs.subtract((T) object, (T) inc);}
public int get(String name, int dflt) {int vals[] = (int[]) valByRound.get(name);if (vals != null) {return vals[roundNumber % vals.length];}String sval = props.getProperty(name, "" + dflt);if (sval.indexOf(":") < 0) {return Integer.parseInt(sval);}int k = sval.indexOf(":");String colName = sval.substring(0, k);sval = sval.substring(k + 1);colForValByRound.put(name, colName);vals = propToIntArray(sval);valByRound.put(name, vals);return vals[roundNumber % vals.length];}
public String toString(String field) {StringBuilder buffer = new StringBuilder();if (!term.field().equals(field)) {buffer.append(term.field());buffer.append(":");}buffer.append(term.text());return buffer.toString();}
public DeleteHsmClientCertificateResult deleteHsmClientCertificate(DeleteHsmClientCertificateRequest request) {request = beforeClientExecution(request);return executeDeleteHsmClientCertificate(request);}
public ListAccountsResult listAccounts(ListAccountsRequest request) {request = beforeClientExecution(request);return executeListAccounts(request);}
public ListTagsResult listTags(ListTagsRequest request) {request = beforeClientExecution(request);return executeListTags(request);}
public List<Note> call() throws GitAPIException {checkCallable();List<Note> notes = new ArrayList<>();NoteMap map = NoteMap.newEmptyMap();try (RevWalk walk = new RevWalk(repo)) {Ref ref = repo.findRef(notesRef);if (ref != null) {RevCommit notesCommit = walk.parseCommit(ref.getObjectId());map = NoteMap.read(walk.getObjectReader(), notesCommit);}Iterator<Note> i = map.iterator();while (i.hasNext())notes.add(i.next());} catch (IOException e) {throw new JGitInternalException(e.getMessage(), e);}return notes;}
public CreateResolverEndpointResult createResolverEndpoint(CreateResolverEndpointRequest request) {request = beforeClientExecution(request);return executeCreateResolverEndpoint(request);}
public GetManagedScalingPolicyResult getManagedScalingPolicy(GetManagedScalingPolicyRequest request) {request = beforeClientExecution(request);return executeGetManagedScalingPolicy(request);}
public QueryNodeProcessor set(int index, QueryNodeProcessor processor) {QueryNodeProcessor oldProcessor = this.processors.set(index, processor);if (oldProcessor != processor) {processor.setQueryConfigHandler(this.queryConfig);}return oldProcessor;}
public GetTransitGatewayRouteTablePropagationsResult getTransitGatewayRouteTablePropagations(GetTransitGatewayRouteTablePropagationsRequest request) {request = beforeClientExecution(request);return executeGetTransitGatewayRouteTablePropagations(request);}
public GetDocumentationPartsResult getDocumentationParts(GetDocumentationPartsRequest request) {request = beforeClientExecution(request);return executeGetDocumentationParts(request);}
public RegisterImageResult registerImage(RegisterImageRequest request) {request = beforeClientExecution(request);return executeRegisterImage(request);}
public GetHLSStreamingSessionURLResult getHLSStreamingSessionURL(GetHLSStreamingSessionURLRequest request) {request = beforeClientExecution(request);return executeGetHLSStreamingSessionURL(request);}
public String toString() {return '[' + "HEADERFOOTER" + "] (0x" +Integer.toHexString(sid).toUpperCase(Locale.ROOT) + ")\n" +"  rawData=" + HexDump.toHex(_rawData) + "\n" +"[/" + "HEADERFOOTER" + "]\n";}
public SuspendProcessesResult suspendProcesses(SuspendProcessesRequest request) {request = beforeClientExecution(request);return executeSuspendProcesses(request);}
public Vector( short type ) {this._type = type;}
public int getIndexOfName(String name) {for (int i = 0; i < _externalNameRecords.length; i++) {if (_externalNameRecords[i].getText().equalsIgnoreCase(name)) {return i;}}return -1;}
public CanonicalTreeParser getParent() {return (CanonicalTreeParser) parent;}
public Query getQuery(Element e) throws ParserException {String text = DOMUtils.getText(e);try {Query q = null;if (unSafeParser != null) {synchronized (unSafeParser) {q = unSafeParser.parse(text);}} else {String fieldName = DOMUtils.getAttribute(e, "fieldName", defaultField);QueryParser parser = createQueryParser(fieldName, analyzer);q = parser.parse(text);}float boost = DOMUtils.getAttribute(e, "boost", 1.0f);return new BoostQuery(q, boost);} catch (ParseException e1) {throw new ParserException(e1.getMessage());}}
public ClassificationResult(T assignedClass, double score) {this.assignedClass = assignedClass;this.score = score;}
public void writeData(final ByteBuffer block) {block.put( serialize() );}
public SendMessageRequest() {super("OnsMqtt", "2019-12-11", "SendMessage", "onsmqtt");setMethod(MethodType.POST);}
public BufferedChecksumIndexInput(IndexInput main) {super("BufferedChecksumIndexInput(" + main + ")");this.main = main;this.digest = new BufferedChecksum(new CRC32());}
public DeletePublishingDestinationResult deletePublishingDestination(DeletePublishingDestinationRequest request) {request = beforeClientExecution(request);return executeDeletePublishingDestination(request);}
public ByteArrayBackedDataSource(byte[] data, int size) { this.buffer = data;this.size = size;}
public DeleteMessageBatchRequestEntry(String id, String receiptHandle) {setId(id);setReceiptHandle(receiptHandle);}
public TokenStream create(TokenStream input) {return new PortugueseMinimalStemFilter(input);}
public DelimitedPayloadTokenFilterFactory(Map<String, String> args) {super(args);encoderClass = require(args, ENCODER_ATTR);delimiter = getChar(args, DELIMITER_ATTR, '|');if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameters: " + args);}}
public DeleteMessageResult deleteMessage(String queueUrl, String receiptHandle) {return deleteMessage(new DeleteMessageRequest().withQueueUrl(queueUrl).withReceiptHandle(receiptHandle));}
public SelectRequest(String selectExpression) {setSelectExpression(selectExpression);}
public void serialize(LittleEndianOutput out) {out.writeByte(getAddMenuCount());out.writeByte(getDelMenuCount());}
public StringBuilder append(char[] chars) {append0(chars);return this;}
public MulBlankRecord clone() {return copy();}
public CreateLaunchTemplateResult createLaunchTemplate(CreateLaunchTemplateRequest request) {request = beforeClientExecution(request);return executeCreateLaunchTemplate(request);}
public CreateDirectConnectGatewayAssociationProposalResult createDirectConnectGatewayAssociationProposal(CreateDirectConnectGatewayAssociationProposalRequest request) {request = beforeClientExecution(request);return executeCreateDirectConnectGatewayAssociationProposal(request);}
public void publish(Revision revision) throws IOException {throw new UnsupportedOperationException("this replicator implementation does not support remote publishing of revisions");}
public ListPipelinesResult listPipelines(ListPipelinesRequest request) {request = beforeClientExecution(request);return executeListPipelines(request);}
public String toString() {return super.toString() + ": " + lockName;}
public CreateResourceResult createResource(CreateResourceRequest request) {request = beforeClientExecution(request);return executeCreateResource(request);}
public CharSequence toQueryString(EscapeQuerySyntax escapeSyntaxParser) {if (getChildren() == null || getChildren().size() == 0)return "";StringBuilder sb = new StringBuilder();String filler = "";for (QueryNode child : getChildren()) {sb.append(filler).append(child.toQueryString(escapeSyntaxParser));filler = ",";}return "[TP[" + sb.toString() + "]]";}
public LongBuffer get(long[] dst) {return get(dst, 0, dst.length);}
public PutLifecycleConfigurationResult putLifecycleConfiguration(PutLifecycleConfigurationRequest request) {request = beforeClientExecution(request);return executePutLifecycleConfiguration(request);}
public int getCellsVal() {int size = 0;for (Row row : rows)size += row.getCellsVal();return size;}
public ListMultipartUploadsRequest(String vaultName) {setVaultName(vaultName);}
public DescribeChangeSetResult describeChangeSet(DescribeChangeSetRequest request) {request = beforeClientExecution(request);return executeDescribeChangeSet(request);}
public CharSequence toQueryString(EscapeQuerySyntax escapeSyntaxParser) {if (getChildren() == null || getChildren().size() == 0)return "";StringBuilder sb = new StringBuilder();String filler = "";for (QueryNode child : getChildren()) {sb.append(filler).append(child.toQueryString(escapeSyntaxParser));filler = " ";}if ((getParent() != null && getParent() instanceof GroupQueryNode)|| isRoot())return sb.toString();elsereturn "( " + sb.toString() + " )";}
public synchronized Collection<V> values() {Collection<V> vs = values;return (vs != null) ? vs : (values = new Values());}
public RecursivePrefixTreeStrategy(SpatialPrefixTree grid, String fieldName) {super(grid, fieldName);prefixGridScanLevel = grid.getMaxLevels() - 4;}
public CreateVpcResult createVpc(CreateVpcRequest request) {request = beforeClientExecution(request);return executeCreateVpc(request);}
public int fillFields(byte[] data, int offset, EscherRecordFactory recordFactory) {int bytesRemaining = readHeader( data, offset );int pos            = offset + 8;int size           = 0;field_1_color1 =  LittleEndian.getInt( data, pos + size );size+=4;field_2_color2 =  LittleEndian.getInt( data, pos + size );size+=4;field_3_color3 =  LittleEndian.getInt( data, pos + size );size+=4;field_4_color4 =  LittleEndian.getInt( data, pos + size );size+=4;bytesRemaining -= size;if (bytesRemaining != 0) {throw new RecordFormatException("Expecting no remaining data but got " + bytesRemaining + " byte(s).");}return 8 + size + bytesRemaining;}
public String getNewPath() {return newPath;}
public BytesRef subtract(BytesRef output, BytesRef inc) {assert output != null;assert inc != null;if (inc == NO_OUTPUT) {return output;} else {assert StringHelper.startsWith(output, inc);if (inc.length == output.length) {return NO_OUTPUT;} else {assert inc.length < output.length: "inc.length=" + inc.length + " vs output.length=" + output.length;assert inc.length > 0;return new BytesRef(output.bytes, output.offset + inc.length, output.length-inc.length);}}}
public AddNoteCommand setMessage(String message) {checkCallable();this.message = message;return this;}
public synchronized void setIndexFieldName(String dimName, String indexFieldName) {DimConfig ft = fieldTypes.get(dimName);if (ft == null) {ft = new DimConfig();fieldTypes.put(dimName, ft);}ft.indexFieldName = indexFieldName;}
public StringBufferInputStream(String str) {if (str == null) {throw new NullPointerException();}buffer = str;count = str.length();}
public long getOffset() {return position;}
public int getColumnNumber() { return column; }
public SendMessageBatchResult sendMessageBatch(SendMessageBatchRequest request) {request = beforeClientExecution(request);return executeSendMessageBatch(request);}
public ChangeTagsForResourceResult changeTagsForResource(ChangeTagsForResourceRequest request) {request = beforeClientExecution(request);return executeChangeTagsForResource(request);}
public void inform(ResourceLoader loader) throws IOException {if (stopWordFiles != null) {if (FORMAT_WORDSET.equalsIgnoreCase(format)) {stopWords = getWordSet(loader, stopWordFiles, ignoreCase);} else if (FORMAT_SNOWBALL.equalsIgnoreCase(format)) {stopWords = getSnowballWordSet(loader, stopWordFiles, ignoreCase);} else {throw new IllegalArgumentException("Unknown 'format' specified for 'words' file: " + format);}} else {if (null != format) {throw new IllegalArgumentException("'format' can not be specified w/o an explicit 'words' file: " + format);}stopWords = new CharArraySet(EnglishAnalyzer.ENGLISH_STOP_WORDS_SET, ignoreCase);}}
public final void serialize(LittleEndianOutput out) {out.writeShort(getRow());out.writeShort(getColumn());out.writeShort(getXFIndex());serializeValue(out);}
public CreateBuildResult createBuild(CreateBuildRequest request) {request = beforeClientExecution(request);return executeCreateBuild(request);}
public ListIdentitiesResult listIdentities(ListIdentitiesRequest request) {request = beforeClientExecution(request);return executeListIdentities(request);}
public ScandinavianFoldingFilterFactory(Map<String,String> args) {super(args);if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameters: " + args);}}
public List<Integer> toList() {List<Integer> values = new ArrayList<Integer>();int n = intervals.size();for (int i = 0; i < n; i++) {Interval I = intervals.get(i);int a = I.a;int b = I.b;for (int v=a; v<=b; v++) {values.add(v);}}return values;}
public UpdatePipelineResult updatePipeline(UpdatePipelineRequest request) {request = beforeClientExecution(request);return executeUpdatePipeline(request);}
public String getLineText() {final int eol = RawParseUtils.nextLF(buf, offset);return RawParseUtils.decode(UTF_8, buf, offset, eol);}
public ListMultipartUploadsRequest(String accountId, String vaultName) {setAccountId(accountId);setVaultName(vaultName);}
public RegisterTaskDefinitionResult registerTaskDefinition(RegisterTaskDefinitionRequest request) {request = beforeClientExecution(request);return executeRegisterTaskDefinition(request);}
public ParseException(Token currentTokenVal,int[][] expectedTokenSequencesVal,String[] tokenImageVal){super(initialise(currentTokenVal, expectedTokenSequencesVal, tokenImageVal));currentToken = currentTokenVal;expectedTokenSequences = expectedTokenSequencesVal;tokenImage = tokenImageVal;}
public int compare(Property o1, Property o2){String VBA_PROJECT = "_VBA_PROJECT";String name1  = o1.getName();String name2  = o2.getName();int  result = name1.length() - name2.length();if (result == 0){if (name1.compareTo(VBA_PROJECT) == 0)result = 1;else if (name2.compareTo(VBA_PROJECT) == 0)result = -1;else{if (name1.startsWith("__") && name2.startsWith("__")){result = name1.compareToIgnoreCase(name2);}else if (name1.startsWith("__")){result = 1;}else if (name2.startsWith("__")){result = -1;}elseresult = name1.compareToIgnoreCase(name2);}}return result;}
final public List<SrndQuery> FieldsQueryList() throws ParseException {SrndQuery q;ArrayList<SrndQuery> queries = new ArrayList<SrndQuery>();jj_consume_token(LPAREN);q = FieldsQuery();queries.add(q);label_7:while (true) {jj_consume_token(COMMA);q = FieldsQuery();queries.add(q);switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {case COMMA:;break;default:jj_la1[7] = jj_gen;break label_7;}}jj_consume_token(RPAREN);{if (true) return queries;}throw new Error("Missing return statement in function");}
public ObjectId idFor(TreeFormatter formatter) {return delegate().idFor(formatter);}
public DescribeResourceResult describeResource(DescribeResourceRequest request) {request = beforeClientExecution(request);return executeDescribeResource(request);}
public final float[] array() {return protectedArray();}
public void removeCharCount() {remove1stProperty(PropertyIDMap.PID_CHARCOUNT);}
public ValueEval evaluate(ValueEval[] args, int srcRowIndex, int srcColumnIndex) {int nInnerArgs = args.length-1; if (nInnerArgs < 1) {return ErrorEval.VALUE_INVALID;}final Function innerFunc;int functionCode = 0;try {ValueEval ve = OperandResolver.getSingleValue(args[0], srcRowIndex, srcColumnIndex);functionCode = OperandResolver.coerceValueToInt(ve);innerFunc = findFunction(functionCode);} catch (EvaluationException e) {return e.getErrorEval();}final List<ValueEval> list = new ArrayList<>(Arrays.asList(args).subList(1, args.length));Iterator<ValueEval> it = list.iterator();while(it.hasNext()) {ValueEval eval = it.next();if(eval instanceof LazyRefEval) {LazyRefEval lazyRefEval = (LazyRefEval) eval;if(lazyRefEval.isSubTotal()) {it.remove();}if (functionCode > 100 && lazyRefEval.isRowHidden()) {it.remove();}}}return innerFunc.evaluate(list.toArray(new ValueEval[0]), srcRowIndex, srcColumnIndex);}
public StopTransformJobResult stopTransformJob(StopTransformJobRequest request) {request = beforeClientExecution(request);return executeStopTransformJob(request);}
public Enumeration<String> keys() {return new Iterator();}
public DeleteBrokerResult deleteBroker(DeleteBrokerRequest request) {request = beforeClientExecution(request);return executeDeleteBroker(request);}
public boolean contains(Object o) {return map.containsKey(o);}
public Set<String> getCapabilities() {return command.getCapabilities();}
public char previous() {if (offset == start) {return DONE;}return string.charAt(--offset);}
public LongBuffer put(long[] src, int srcOffset, int longCount) {if (longCount > remaining()) {throw new BufferOverflowException();}System.arraycopy(src, srcOffset, backingArray, offset + position, longCount);position += longCount;return this;}
public ModifyInstancePlacementResult modifyInstancePlacement(ModifyInstancePlacementRequest request) {request = beforeClientExecution(request);return executeModifyInstancePlacement(request);}
public void removeSheet(int sheetIdx) {_externSheetRecord.removeSheet(sheetIdx);}
public GetUserResult getUser(GetUserRequest request) {request = beforeClientExecution(request);return executeGetUser(request);}
public SynonymQuery build() {Collections.sort(terms, Comparator.comparing(a -> a.term));return new SynonymQuery(terms.toArray(new TermAndBoost[0]), field);}
public UpdateApnsChannelResult updateApnsChannel(UpdateApnsChannelRequest request) {request = beforeClientExecution(request);return executeUpdateApnsChannel(request);}
public boolean contains(Object needle) {if (needle instanceof String) {String n = (String) needle;return names.containsKey(n)|| names.containsKey(StringUtils.toLowerCase(n));}return false;}
public PersonIdent getSourceCommitter(int idx) {return sourceCommitters[idx];}
public CreateNetworkAclResult createNetworkAcl(CreateNetworkAclRequest request) {request = beforeClientExecution(request);return executeCreateNetworkAcl(request);}
public BeginRecord clone() {return copy();}
final public QueryNode ConjQuery(CharSequence field) throws ParseException {QueryNode first, c;Vector<QueryNode> clauses = null;first = ModClause(field);label_3:while (true) {switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {case AND:;break;default:jj_la1[4] = jj_gen;break label_3;}jj_consume_token(AND);c = ModClause(field);if (clauses == null) {clauses = new Vector<QueryNode>();clauses.addElement(first);}clauses.addElement(c);}if (clauses != null) {{if (true) return new AndQueryNode(clauses);}} else {{if (true) return first;}}throw new Error("Missing return statement in function");}
public final int getEndA() {return endA;}
public ArabicStemFilterFactory(Map<String,String> args) {super(args);if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameters: " + args);}}
public HSSFFormulaEvaluator createFormulaEvaluator(){return new HSSFFormulaEvaluator(workbook);}
public void removeMMClipCount() {remove1stProperty(PropertyIDMap.PID_MMCLIPCOUNT);}
public ExternalBookBlock(String url, String[] sheetNames) {_externalBookRecord = SupBookRecord.createExternalReferences(url, sheetNames);_crnBlocks = new CRNBlock[0];}
public static byte[] encode(String str) {final ByteBuffer bb = UTF_8.encode(str);final int len = bb.limit();if (bb.hasArray() && bb.arrayOffset() == 0) {final byte[] arr = bb.array();if (arr.length == len)return arr;}final byte[] arr = new byte[len];bb.get(arr);return arr;}
public RebootWorkspacesResult rebootWorkspaces(RebootWorkspacesRequest request) {request = beforeClientExecution(request);return executeRebootWorkspaces(request);}
public DistributionConfig(String callerReference, Boolean enabled) {setCallerReference(callerReference);setEnabled(enabled);}
public static boolean isContainer(short options, short recordId){if(recordId >= EscherContainerRecord.DGG_CONTAINER &&  recordId<= EscherContainerRecord.SOLVER_CONTAINER){return true;} else {if (recordId == EscherTextboxRecord.RECORD_ID) {return false;} else {return ( options & (short) 0x000F ) == (short) 0x000F;}}}
@Override public void clear() {if (size != 0) {Arrays.fill(array, 0, size, null);size = 0;modCount++;}}
public GetDownloadUrlsRequest() {super("CloudPhoto", "2017-07-11", "GetDownloadUrls", "cloudphoto");setProtocol(ProtocolType.HTTPS);}
public String toString() {return getClass().getName() + " [" + asFormulaString() + "]";}
public boolean isNewFragment() {boolean isNewFrag = offsetAtt.endOffset() >= (fragmentSize * currentNumFrags);if (isNewFrag) {currentNumFrags++;}return isNewFrag;}
public GridsetRecord clone() {return copy();}
public LeftMarginRecord clone() {return copy();}
public void execute(Lexer lexer) {lexer.skip();}
public String toString(){StringBuilder buffer = new StringBuilder();buffer.append("[COUNTRY]\n");buffer.append("    .defaultcountry  = ").append(Integer.toHexString(getDefaultCountry())).append("\n");buffer.append("    .currentcountry  = ").append(Integer.toHexString(getCurrentCountry())).append("\n");buffer.append("[/COUNTRY]\n");return buffer.toString();}
public String toString() {StringBuilder buffer = new StringBuilder("[Data Table - Parent cell is an interior cell in a data table]\n");buffer.append("top left row = ").append(getRow()).append("\n");buffer.append("top left col = ").append(getColumn()).append("\n");return buffer.toString();}
public synchronized Set<Entry<K, V>> entrySet() {Set<Entry<K, V>> es = entrySet;return (es != null) ? es : (entrySet = new EntrySet());}
public RevCommit getSourceCommit(int idx) {return sourceCommits[idx];}
public DBInstanceAutomatedBackup deleteDBInstanceAutomatedBackup(DeleteDBInstanceAutomatedBackupRequest request) {request = beforeClientExecution(request);return executeDeleteDBInstanceAutomatedBackup(request);}
public ValueEval evaluate(ValueEval[] args, OperationEvaluationContext ec) {if (args.length != 1) {return ErrorEval.VALUE_INVALID;}int val;try {val = evaluateArgParity(args[0], ec.getRowIndex(), ec.getColumnIndex());} catch (EvaluationException e) {return e.getErrorEval();}return BoolEval.valueOf(val == _desiredParity);}
public boolean exists(String fileName) {assert locked();if (!refCounts.containsKey(fileName)) {return false;} else {return getRefCount(fileName).count > 0;}}
public GetRelationalDatabaseBlueprintsResult getRelationalDatabaseBlueprints(GetRelationalDatabaseBlueprintsRequest request) {request = beforeClientExecution(request);return executeGetRelationalDatabaseBlueprints(request);}
public CreateStageResult createStage(CreateStageRequest request) {request = beforeClientExecution(request);return executeCreateStage(request);}
public ObjectId getExpectedOldObjectId() {return expValue;}
public GetVpcLinksResult getVpcLinks(GetVpcLinksRequest request) {request = beforeClientExecution(request);return executeGetVpcLinks(request);}
public DeleteIAMPolicyAssignmentResult deleteIAMPolicyAssignment(DeleteIAMPolicyAssignmentRequest request) {request = beforeClientExecution(request);return executeDeleteIAMPolicyAssignment(request);}
public void clear() {map.clear();}
public ProfilingATNSimulator(Parser parser) {super(parser,parser.getInterpreter().atn,parser.getInterpreter().decisionToDFA,parser.getInterpreter().sharedContextCache);numDecisions = atn.decisionToState.size();decisions = new DecisionInfo[numDecisions];for (int i=0; i<numDecisions; i++) {decisions[i] = new DecisionInfo(i);}}
public BOFRecord(RecordInputStream in) {field_1_version  = in.readShort();field_2_type     = in.readShort();if (in.remaining() >= 2) {field_3_build = in.readShort();}if (in.remaining() >= 2) {field_4_year = in.readShort();}if (in.remaining() >= 4) {field_5_history  = in.readInt();}if (in.remaining() >= 4) {field_6_rversion = in.readInt();}}
public DescribeClientVpnTargetNetworksResult describeClientVpnTargetNetworks(DescribeClientVpnTargetNetworksRequest request) {request = beforeClientExecution(request);return executeDescribeClientVpnTargetNetworks(request);}
public void serialize(LittleEndianOutput out) {throw new RecordFormatException( "Sorry, you can't serialize MulRK in this release");}
public static String escape(String s) {StringBuilder sb = new StringBuilder();for (int i = 0; i < s.length(); i++) {char c = s.charAt(i);if (c == '\\' || c == '+' || c == '-' || c == '!' || c == '(' || c == ')'|| c == ':' || c == '^' || c == '[' || c == ']' || c == '\"'|| c == '{' || c == '}' || c == '~' || c == '*' || c == '?'|| c == '|' || c == '&' || c == '/') {sb.append('\\');}sb.append(c);}return sb.toString();}
public Map<String, MergeResult<? extends Sequence>> getMergeResults() {return mergeResults;}
public SearchFacesResult searchFaces(SearchFacesRequest request) {request = beforeClientExecution(request);return executeSearchFaces(request);}
public final boolean isDirect() {return false;}
public static IntervalSet of(int a, int b) {IntervalSet s = new IntervalSet();s.add(a,b);return s;}
public ReplicationGroup completeMigration(CompleteMigrationRequest request) {request = beforeClientExecution(request);return executeCompleteMigration(request);}
public char[] nextKey() {goNext();return keys[lastPos];}
public GetAccountSettingsResult getAccountSettings(GetAccountSettingsRequest request) {request = beforeClientExecution(request);return executeGetAccountSettings(request);}
public BatchDetectSyntaxResult batchDetectSyntax(BatchDetectSyntaxRequest request) {request = beforeClientExecution(request);return executeBatchDetectSyntax(request);}
public String getResultPath() {return resultPath;}
public StemmerOverrideFilterFactory(Map<String,String> args) {super(args);dictionaryFiles = get(args, "dictionary");ignoreCase = getBoolean(args, "ignoreCase", false);if (!args.isEmpty()) {throw new IllegalArgumentException("Unknown parameters: " + args);}}
public DisassociateSkillFromSkillGroupResult disassociateSkillFromSkillGroup(DisassociateSkillFromSkillGroupRequest request) {request = beforeClientExecution(request);return executeDisassociateSkillFromSkillGroup(request);}
public DeltaIndex(byte[] sourceBuffer) {src = sourceBuffer;DeltaIndexScanner scan = new DeltaIndexScanner(src, src.length);table = scan.table;tableMask = scan.tableMask;entries = new long[1 + countEntries(scan)];copyEntries(scan);}
public ListAccountSettingsResult listAccountSettings(ListAccountSettingsRequest request) {request = beforeClientExecution(request);return executeListAccountSettings(request);}
public InviteUsersResult inviteUsers(InviteUsersRequest request) {request = beforeClientExecution(request);return executeInviteUsers(request);}
public String getPath() {return path;}
public DeleteTableRequest(String tableName) {setTableName(tableName);}
public TokenFilter create(TokenStream input) {return new KStemFilter(input);}
public int read(char[] c, int off, int len) {if (pos < size) {len = Math.min(len, size-pos);s.getChars(pos, pos+len, c, off);pos += len;return len;} else {s = null;return -1;}}
public ByteBlockPool(Allocator allocator) {this.allocator = allocator;}
public long ramBytesUsed() {long ramBytesUsed = postingsReader.ramBytesUsed();for (TermsReader r : fields.values()) {ramBytesUsed += r.ramBytesUsed();}return ramBytesUsed;}
public int end(int group) {ensureMatch();return matchOffsets[(group * 2) + 1];}
public static long getResultSize(byte[] delta) {int p = 0;int c;do {c = delta[p++] & 0xff;} while ((c & 0x80) != 0);long resLen = 0;int shift = 0;do {c = delta[p++] & 0xff;resLen |= ((long) (c & 0x7f)) << shift;shift += 7;} while ((c & 0x80) != 0);return resLen;}
public void setMaxDocFreqPct(int maxPercentage) {setMaxDocFreq(Math.toIntExact((long) maxPercentage * ir.maxDoc() / 100));}
public DetectDominantLanguageResult detectDominantLanguage(DetectDominantLanguageRequest request) {request = beforeClientExecution(request);return executeDetectDominantLanguage(request);}
public ParseTreePattern compile(String pattern, int patternRuleIndex) {List<? extends Token> tokenList = tokenize(pattern);ListTokenSource tokenSrc = new ListTokenSource(tokenList);CommonTokenStream tokens = new CommonTokenStream(tokenSrc);ParserInterpreter parserInterp = new ParserInterpreter(parser.getGrammarFileName(),parser.getVocabulary(),Arrays.asList(parser.getRuleNames()),parser.getATNWithBypassAlts(),tokens);ParseTree tree = null;try {parserInterp.setErrorHandler(new BailErrorStrategy());tree = parserInterp.parse(patternRuleIndex);}catch (ParseCancellationException e) {throw (RecognitionException)e.getCause();}catch (RecognitionException re) {throw re;}catch (Exception e) {throw new CannotInvokeStartRule(e);}if ( tokens.LA(1)!=Token.EOF ) {throw new StartRuleDoesNotConsumeFullPattern();}return new ParseTreePattern(this, pattern, patternRuleIndex, tree);}
public boolean isIndexTerm(BytesRef term, TermStats stats) {if (count >= interval) {count = 1;return true;} else {count++;return false;}}
public static Collection<String> getNotSupportedFunctionNames(){Collection<String> lst = new TreeSet<>();lst.addAll(FunctionEval.getNotSupportedFunctionNames());lst.addAll(AnalysisToolPak.getNotSupportedFunctionNames());return Collections.unmodifiableCollection(lst);}
public StreamCopyThread(InputStream i, OutputStream o) {setName(Thread.currentThread().getName() + "-StreamCopy"); src = i;dst = o;writeLock = new Object();}
public static boolean isComponentRecord(int sid) {switch (sid) {case ProtectRecord.sid:case ObjectProtectRecord.sid:case ScenarioProtectRecord.sid:case PasswordRecord.sid:return true;}return false;}
public Collection<String> call() throws GitAPIException {checkCallable();try (SubmoduleWalk generator = SubmoduleWalk.forIndex(repo)) {if (!paths.isEmpty())generator.setFilter(PathFilterGroup.createFromStrings(paths));StoredConfig config = repo.getConfig();List<String> initialized = new ArrayList<>();while (generator.next()) {if (generator.getConfigUrl() != null)continue;String path = generator.getPath();String name = generator.getModuleName();String url = generator.getRemoteUrl();String update = generator.getModulesUpdate();if (url != null)config.setString(ConfigConstants.CONFIG_SUBMODULE_SECTION,name, ConfigConstants.CONFIG_KEY_URL, url);if (update != null)config.setString(ConfigConstants.CONFIG_SUBMODULE_SECTION,name, ConfigConstants.CONFIG_KEY_UPDATE, update);if (url != null || update != null)initialized.add(path);}if (!initialized.isEmpty())config.save();return initialized;} catch (IOException | ConfigInvalidException e) {throw new JGitInternalException(e.getMessage(), e);}}
public CharBlockArray append(CharSequence chars) {return append(chars, 0, chars.length());}
@Override public int indexOf(Object object) {Slice slice = this.slice;Object[] snapshot = elements;slice.checkConcurrentModification(snapshot);int result = CopyOnWriteArrayList.indexOf(object, snapshot, slice.from, slice.to);return (result != -1) ? (result - slice.from) : -1;}
public FontBasisRecord(RecordInputStream in){field_1_xBasis                 = in.readShort();field_2_yBasis                 = in.readShort();field_3_heightBasis            = in.readShort();field_4_scale                  = in.readShort();field_5_indexToFontTable       = in.readShort();}
public int compareTo(ScoreTerm other) {if (term.bytesEquals(other.term))return 0; if (this.boost == other.boost)return other.term.compareTo(this.term);elsereturn Float.compare(this.boost, other.boost);}
public DescribeFleetUtilizationResult describeFleetUtilization(DescribeFleetUtilizationRequest request) {request = beforeClientExecution(request);return executeDescribeFleetUtilization(request);}
public static String fromDouble(Double d) {return Double.toString(d);}
public String getSignificantDecimalDigitsLastDigitRounded() {long wp = _wholePart + 5; StringBuilder sb = new StringBuilder(24);sb.append(wp);sb.setCharAt(sb.length()-1, '0');return sb.toString();}
public boolean shouldRefresh() {long now = System.currentTimeMillis();return now - lastFailedRefreshTime > refreshIntervalInMillSeconds;}
public static int getBiasedExponent(long rawBits) {return Math.toIntExact((rawBits & EXPONENT_MASK) >> EXPONENT_SHIFT);}
public int getDeltaSearchWindowSize() {return deltaSearchWindowSize;}
public void copy(MutableValue source) {MutableValueStr s = (MutableValueStr) source;exists = s.exists;value.copyBytes(s.value);}
