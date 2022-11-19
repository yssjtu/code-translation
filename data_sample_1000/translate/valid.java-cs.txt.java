public int getHeight(){return _height;}
public DescribeReservedInstancesResult describeReservedInstances() {return describeReservedInstances(new DescribeReservedInstancesRequest());}
public void serialize(LittleEndianOutput out) {out.writeShort(_extBookIndex);out.writeShort(_firstSheetIndex);out.writeShort(_lastSheetIndex);}
public K getKey() {return key;}
public void setPackedGitMMAP(boolean usemmap) {packedGitMMAP = usemmap;}
public ListIdentityPoolUsageResult listIdentityPoolUsage(ListIdentityPoolUsageRequest request) {request = beforeClientExecution(request);return executeListIdentityPoolUsage(request);}
public TerminateInstancesResult terminateInstances(TerminateInstancesRequest request) {request = beforeClientExecution(request);return executeTerminateInstances(request);}
public ObjectDatabase newCachedDatabase() {return this;}
public FileTreeIterator(File root, FS fs, WorkingTreeOptions options) {this(root, fs, options, DefaultFileModeStrategy.INSTANCE);}
public static void register(TransportProtocol proto) {protocols.add(0, new WeakReference<>(proto));}
public DescribeVolumeStatusResult describeVolumeStatus(DescribeVolumeStatusRequest request) {request = beforeClientExecution(request);return executeDescribeVolumeStatus(request);}
public DescribeTrainingJobResult describeTrainingJob(DescribeTrainingJobRequest request) {request = beforeClientExecution(request);return executeDescribeTrainingJob(request);}
public UpdateCustomVerificationEmailTemplateResult updateCustomVerificationEmailTemplate(UpdateCustomVerificationEmailTemplateRequest request) {request = beforeClientExecution(request);return executeUpdateCustomVerificationEmailTemplate(request);}
public void decode(byte[] blocks, int blocksOffset, long[] values, int valuesOffset, int iterations) {for (int j = 0; j < iterations; ++j) {values[valuesOffset++] = blocks[blocksOffset++] & 0xFF;}}
public static final int commitMessage(byte[] b, int ptr) {final int sz = b.length;if (ptr == 0)ptr += 46; while (ptr < sz && b[ptr] == 'p')ptr += 48; return tagMessage(b, ptr);}
public CreateAlbumRequest() {super("CloudPhoto", "2017-07-11", "CreateAlbum", "cloudphoto");setProtocol(ProtocolType.HTTPS);}
public CreateEnvironmentResult createEnvironment(CreateEnvironmentRequest request) {request = beforeClientExecution(request);return executeCreateEnvironment(request);}
@Override public V put(K key, V value) {if (!isInBounds(key)) {throw outOfBounds(key, fromBound, toBound);}return putInternal(key, value);}
public static String getFromUnicodeLE(byte[] string) {if (string.length == 0) {return "";}return getFromUnicodeLE(string, 0, string.length / 2);}
public void add(RevCommit c) {Block b = tail;if (b == null) {b = free.newBlock();b.add(c);head = b;tail = b;return;} else if (b.isFull()) {b = free.newBlock();tail.next = b;tail = b;}b.add(c);}
public UpdateFieldLevelEncryptionProfileResult updateFieldLevelEncryptionProfile(UpdateFieldLevelEncryptionProfileRequest request) {request = beforeClientExecution(request);return executeUpdateFieldLevelEncryptionProfile(request);}
public String toString() {return "Token(\"" + new String(surfaceForm, offset, length) + "\" pos=" + position + " length=" + length +" posLen=" + positionLength + " type=" + type + " wordId=" + wordId +" leftID=" + dictionary.getLeftId(wordId) + ")";}
public DescribeInstanceTypesResult describeInstanceTypes(DescribeInstanceTypesRequest request) {request = beforeClientExecution(request);return executeDescribeInstanceTypes(request);}
public final CoderResult flush(CharBuffer out) {if (status != END && status != INIT) {throw new IllegalStateException();}CoderResult result = implFlush(out);if (result == CoderResult.UNDERFLOW) {status = FLUSH;}return result;}
public SeriesRecord(RecordInputStream in) {field_1_categoryDataType = in.readShort();field_2_valuesDataType   = in.readShort();field_3_numCategories    = in.readShort();field_4_numValues        = in.readShort();field_5_bubbleSeriesType = in.readShort();field_6_numBubbleValues  = in.readShort();}
public synchronized void setProgress(int progress) {setProgress(progress, false);}
public void setKeepEmpty(boolean empty) {keepEmpty = empty;}
public String toFormulaString(FormulaRenderingWorkbook book) {return ExternSheetNameResolver.prependSheetName(book, field_1_index_extern_sheet, formatReferenceAsString());}
public RevBlob lookupBlob(AnyObjectId id) {RevBlob c = (RevBlob) objects.get(id);if (c == null) {c = new RevBlob(id);objects.add(c);}return c;}
public ByteBuffer put(byte b) {throw new ReadOnlyBufferException();}
public CreateSmsTemplateResult createSmsTemplate(CreateSmsTemplateRequest request) {request = beforeClientExecution(request);return executeCreateSmsTemplate(request);}
public static Document loadXML(Reader is) {DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();DocumentBuilder db = null;try {db = dbf.newDocumentBuilder();}catch (Exception se) {throw new RuntimeException("Parser configuration error", se);}org.w3c.dom.Document doc = null;try {doc = db.parse(new InputSource(is));}catch (Exception se) {throw new RuntimeException("Error parsing file:" + se, se);}return doc;}
public E next() {if (iterator.nextIndex() < end) {return iterator.next();}throw new NoSuchElementException();}
public V getValue() {return value;}
public ListUserHierarchyGroupsResult listUserHierarchyGroups(ListUserHierarchyGroupsRequest request) {request = beforeClientExecution(request);return executeListUserHierarchyGroups(request);}
public UnmappableCharacterException(int length) {this.inputLength = length;}
public DescribeProfilingGroupResult describeProfilingGroup(DescribeProfilingGroupRequest request) {request = beforeClientExecution(request);return executeDescribeProfilingGroup(request);}
public CreateDomainResult createDomain(CreateDomainRequest request) {request = beforeClientExecution(request);return executeCreateDomain(request);}
public UpdateBasePathMappingResult updateBasePathMapping(UpdateBasePathMappingRequest request) {request = beforeClientExecution(request);return executeUpdateBasePathMapping(request);}
public ListMetricsResult listMetrics() {return listMetrics(new ListMetricsRequest());}
public DeleteRelationalDatabaseResult deleteRelationalDatabase(DeleteRelationalDatabaseRequest request) {request = beforeClientExecution(request);return executeDeleteRelationalDatabase(request);}
public String toString() {return getType().name() + ": " + getOldId().name() + " "+ getNewId().name() + " " + getRefName();}
public ByteBuffer slice() {return new ReadOnlyHeapByteBuffer(backingArray, remaining(), offset + position);}
public ResetNetworkInterfaceAttributeResult resetNetworkInterfaceAttribute(ResetNetworkInterfaceAttributeRequest request) {request = beforeClientExecution(request);return executeResetNetworkInterfaceAttribute(request);}
public int byteAt(int idx) {return bytes[idx].value;}
@Override public boolean equals(Object object) {if (this == object) {return true;}if (object instanceof Map.Entry) {Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;return (key == null ? entry.getKey() == null : key.equals(entry.getKey()))&& (value == null ? entry.getValue() == null : value.equals(entry.getValue()));}return false;}
public CreateJourneyResult createJourney(CreateJourneyRequest request) {request = beforeClientExecution(request);return executeCreateJourney(request);}
public Set<String> getNames(String section, String subsection) {return getState().getNames(section, subsection);}
public DeleteLifecycleHookResult deleteLifecycleHook(DeleteLifecycleHookRequest request) {request = beforeClientExecution(request);return executeDeleteLifecycleHook(request);}
public void decode(long[] blocks, int blocksOffset, long[] values,int valuesOffset, int iterations) {for (int i = 0; i < iterations; ++i) {final long block = blocks[blocksOffset++];valuesOffset = decode(block, values, valuesOffset);}}
