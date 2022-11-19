public POIFSDocumentPath(){this.components = new String[ 0 ];}
public UpdateLinkAttributesResult updateLinkAttributes(UpdateLinkAttributesRequest request) {request = beforeClientExecution(request);return executeUpdateLinkAttributes(request);}
public final void write(OpenStringBuilder arr) {write(arr.buf, 0, len);}
public DeleteVpnConnectionRouteResult deleteVpnConnectionRoute(DeleteVpnConnectionRouteRequest request) {request = beforeClientExecution(request);return executeDeleteVpnConnectionRoute(request);}
public DeleteSignalingChannelResult deleteSignalingChannel(DeleteSignalingChannelRequest request) {request = beforeClientExecution(request);return executeDeleteSignalingChannel(request);}
public UpdateDetectorVersionMetadataResult updateDetectorVersionMetadata(UpdateDetectorVersionMetadataRequest request) {request = beforeClientExecution(request);return executeUpdateDetectorVersionMetadata(request);}
public Explanation explain(Explanation freq, long norm) {List<Explanation> subs = new ArrayList<>();for (SimScorer subScorer : subScorers) {subs.add(subScorer.explain(freq, norm));}return Explanation.match(score(freq.getValue().floatValue(), norm), "sum of:", subs);}
public ValueEval evaluate(int srcRowIndex, int srcColumnIndex, ValueEval arg0, ValueEval arg1) {double s0;String s1;try {s0 = evaluateDoubleArg(arg0, srcRowIndex, srcColumnIndex);s1 = evaluateStringArg(arg1, srcRowIndex, srcColumnIndex);} catch (EvaluationException e) {return e.getErrorEval();}try {String formattedStr = formatter.formatRawCellContents(s0, -1, s1);return new StringEval(formattedStr);} catch (Exception e) {return ErrorEval.VALUE_INVALID;}}
public void decode(byte[] blocks, int blocksOffset, long[] values, int valuesOffset, int iterations) {for (int i = 0; i < iterations; ++i) {final long byte0 = blocks[blocksOffset++] & 0xFF;values[valuesOffset++] = byte0 >>> 5;values[valuesOffset++] = (byte0 >>> 2) & 7;final long byte1 = blocks[blocksOffset++] & 0xFF;values[valuesOffset++] = ((byte0 & 3) << 1) | (byte1 >>> 7);values[valuesOffset++] = (byte1 >>> 4) & 7;values[valuesOffset++] = (byte1 >>> 1) & 7;final long byte2 = blocks[blocksOffset++] & 0xFF;values[valuesOffset++] = ((byte1 & 1) << 2) | (byte2 >>> 6);values[valuesOffset++] = (byte2 >>> 3) & 7;values[valuesOffset++] = byte2 & 7;}}
public void throwException() throws BufferUnderflowException,BufferOverflowException, UnmappableCharacterException,MalformedInputException, CharacterCodingException {switch (this.type) {case TYPE_UNDERFLOW:throw new BufferUnderflowException();case TYPE_OVERFLOW:throw new BufferOverflowException();case TYPE_UNMAPPABLE_CHAR:throw new UnmappableCharacterException(this.length);case TYPE_MALFORMED_INPUT:throw new MalformedInputException(this.length);default:throw new CharacterCodingException();}}
public void jumpDrawablesToCurrentState() {super.jumpDrawablesToCurrentState();if (mThumb != null) mThumb.jumpToCurrentState();}
public void removeCell(CellValueRecordInterface cell) {if (cell == null) {throw new IllegalArgumentException("cell must not be null");}int row = cell.getRow();if (row >= records.length) {throw new RuntimeException("cell row is out of range");}CellValueRecordInterface[] rowCells = records[row];if (rowCells == null) {throw new RuntimeException("cell row is already empty");}short column = cell.getColumn();if (column >= rowCells.length) {throw new RuntimeException("cell column is out of range");}rowCells[column] = null;}
public DescribeDBClustersResult describeDBClusters(DescribeDBClustersRequest request) {request = beforeClientExecution(request);return executeDescribeDBClusters(request);}
public StringBuffer append(long l) {IntegralToString.appendLong(this, l);return this;}
public int preceding(int pos) {if (pos < start || pos > end) {throw new IllegalArgumentException("offset out of bounds");} else if (pos == start) {current = start;return DONE;} else {return first();}}
public static Class<? extends CharFilterFactory> lookupClass(String name) {return loader.lookupClass(name);}
public GetDocumentVersionResult getDocumentVersion(GetDocumentVersionRequest request) {request = beforeClientExecution(request);return executeGetDocumentVersion(request);}
public static void fill(char[] array, char value) {for (int i = 0; i < array.length; i++) {array[i] = value;}}
public AxisRecord(RecordInputStream in) {field_1_axisType  = in.readShort();field_2_reserved1 = in.readInt();field_3_reserved2 = in.readInt();field_4_reserved3 = in.readInt();field_5_reserved4 = in.readInt();}
public DescribeClusterSecurityGroupsResult describeClusterSecurityGroups() {return describeClusterSecurityGroups(new DescribeClusterSecurityGroupsRequest());}
public Object[] toArray() {int index = 0;Object[] contents = new Object[size];Link<E> link = voidLink.next;while (link != voidLink) {contents[index++] = link.data;link = link.next;}return contents;}
public DescribeOptionGroupsResult describeOptionGroups() {return describeOptionGroups(new DescribeOptionGroupsRequest());}
public GetCelebrityInfoResult getCelebrityInfo(GetCelebrityInfoRequest request) {request = beforeClientExecution(request);return executeGetCelebrityInfo(request);}
public String toString() {StringBuilder sb = new StringBuilder();sb.append('[').append("USERSVIEWEND").append("] (0x");sb.append(Integer.toHexString(sid).toUpperCase(Locale.ROOT)).append(")\n");sb.append("  rawData=").append(HexDump.toHex(_rawData)).append("\n");sb.append("[/").append("USERSVIEWEND").append("]\n");return sb.toString();}
public ParseTreeMatch match(ParseTree tree) {return matcher.match(tree, this);}
public ResetNetworkInterfaceAttributeResult resetNetworkInterfaceAttribute(ResetNetworkInterfaceAttributeRequest request) {request = beforeClientExecution(request);return executeResetNetworkInterfaceAttribute(request);}
public String toFormulaString() {throw invalid();}
public DescribeRepositoryAssociationResult describeRepositoryAssociation(DescribeRepositoryAssociationRequest request) {request = beforeClientExecution(request);return executeDescribeRepositoryAssociation(request);}
public ListDeploymentConfigsResult listDeploymentConfigs() {return listDeploymentConfigs(new ListDeploymentConfigsRequest());}
public DisassociateRouteTableResult disassociateRouteTable(DisassociateRouteTableRequest request) {request = beforeClientExecution(request);return executeDisassociateRouteTable(request);}
public void serialize(LittleEndianOutput out) {out.writeShort(_formats.length);for(int i=0; i<_formats.length; i++){_formats[i].serialize(out);}}
public ValueEval evaluate(ValueEval[] args, OperationEvaluationContext ec) {if (args.length != 2) {return ErrorEval.VALUE_INVALID;}try {double startDateAsNumber = getValue(args[0]);int offsetInMonthAsNumber = (int) getValue(args[1]);Date startDate = DateUtil.getJavaDate(startDateAsNumber);if (startDate == null) {return ErrorEval.VALUE_INVALID;}Calendar calendar = LocaleUtil.getLocaleCalendar();calendar.setTime(startDate);calendar.add(Calendar.MONTH, offsetInMonthAsNumber);return new NumberEval(DateUtil.getExcelDate(calendar.getTime()));} catch (EvaluationException e) {return e.getErrorEval();}}
public GetBlockResult getBlock(GetBlockRequest request) {request = beforeClientExecution(request);return executeGetBlock(request);}
public DisassociateResolverEndpointIpAddressResult disassociateResolverEndpointIpAddress(DisassociateResolverEndpointIpAddressRequest request) {request = beforeClientExecution(request);return executeDisassociateResolverEndpointIpAddress(request);}
public boolean equals(Object obj) {if (this == obj)return true;if (obj == null)return false;if (getClass() != obj.getClass())return false;SegToken other = (SegToken) obj;if (!Arrays.equals(charArray, other.charArray))return false;if (endOffset != other.endOffset)return false;if (index != other.index)return false;if (startOffset != other.startOffset)return false;if (weight != other.weight)return false;if (wordType != other.wordType)return false;return true;}
public CleanCommand clean() {return new CleanCommand(repo);}
public ListStackInstancesResult listStackInstances(ListStackInstancesRequest request) {request = beforeClientExecution(request);return executeListStackInstances(request);}
public ValueEval evaluate(ValueEval[] args, int srcCellRow, int srcCellCol) {double result;try {List<Double> temp = new ArrayList<>();for (ValueEval arg : args) {collectValues(arg, temp);}double[] values = new double[temp.size()];for (int i = 0; i < values.length; i++) {values[i] = temp.get(i).doubleValue();}result = evaluate(values);} catch (EvaluationException e) {return e.getErrorEval();}return new NumberEval(result);}
public CreateAssessmentTemplateResult createAssessmentTemplate(CreateAssessmentTemplateRequest request) {request = beforeClientExecution(request);return executeCreateAssessmentTemplate(request);}
public String toString() {final StringBuilder r = new StringBuilder();r.append("("); for (int i = 0; i < subfilters.length; i++) {if (i > 0)r.append(" OR "); r.append(subfilters[i].toString());}r.append(")"); return r.toString();}
public TreeSet() {backingMap = new TreeMap<E, Object>();}
public void fill(int fromIndex, int toIndex, long val) {assert val <= maxValue(getBitsPerValue());assert fromIndex <= toIndex;for (int i = fromIndex; i < toIndex; ++i) {set(i, val);}}
@Override public Object[] toArray() {return ObjectArrays.toArrayImpl(this);}
public DescribeFlowLogsResult describeFlowLogs(DescribeFlowLogsRequest request) {request = beforeClientExecution(request);return executeDescribeFlowLogs(request);}
public ValueEval getRef3DEval(Ref3DPxg rptg) {SheetRangeEvaluator sre = createExternSheetRefEvaluator(rptg.getSheetName(), rptg.getLastSheetName(), rptg.getExternalWorkbookNumber());return new LazyRefEval(rptg.getRow(), rptg.getColumn(), sre);}
public ListMetricsResult listMetrics() {return listMetrics(new ListMetricsRequest());}
public String toString() {StringBuilder buffer = new StringBuilder();buffer.append("[REFRESHALL]\n");buffer.append("    .options      = ").append(HexDump.shortToHex(_options)).append("\n");buffer.append("[/REFRESHALL]\n");return buffer.toString();}
public XmlPullParser newPullParser() throws XmlPullParserException {if (parserClasses == null) throw new XmlPullParserException("Factory initialization was incomplete - has not tried "+classNamesLocation);if (parserClasses.size() == 0) throw new XmlPullParserException("No valid parser classes found in "+classNamesLocation);final StringBuilder issues = new StringBuilder();for (int i = 0; i < parserClasses.size(); i++) {final Class ppClass = (Class) parserClasses.get(i);try {final XmlPullParser pp = (XmlPullParser) ppClass.newInstance();for (Iterator iter = features.keySet().iterator(); iter.hasNext(); ) {final String key = (String) iter.next();final Boolean value = (Boolean) features.get(key);if(value != null && value.booleanValue()) {pp.setFeature(key, true);}}return pp;} catch(Exception ex) {issues.append (ppClass.getName () + ": "+ ex.toString ()+"; ");}}throw new XmlPullParserException ("could not create parser: "+issues);}
public DoubleBuffer duplicate() {ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());DoubleToByteBufferAdapter buf = new DoubleToByteBufferAdapter(bb);buf.limit = limit;buf.position = position;buf.mark = mark;return buf;}
public ByteBuffer put(byte b) {throw new ReadOnlyBufferException();}
public String resource() {return this.resource;}
public DecreaseReplicationFactorResult decreaseReplicationFactor(DecreaseReplicationFactorRequest request) {request = beforeClientExecution(request);return executeDecreaseReplicationFactor(request);}
public StopContactResult stopContact(StopContactRequest request) {request = beforeClientExecution(request);return executeStopContact(request);}
public DescribeVolumeStatusResult describeVolumeStatus(DescribeVolumeStatusRequest request) {request = beforeClientExecution(request);return executeDescribeVolumeStatus(request);}
public Set<String> getNames(String section) {return getNames(section, null);}
public StringBuffer insert(int index, float f) {return insert(index, Float.toString(f));}
public int advance(int target) {upto++;if (upto == docIDs.length) {return docID = NO_MORE_DOCS;}int inc = 10;int nextUpto = upto+10;int low;int high;while (true) {if (nextUpto >= docIDs.length) {low = nextUpto-inc;high = docIDs.length-1;break;}if (target <= docIDs[nextUpto]) {low = nextUpto-inc;high = nextUpto;break;}inc *= 2;nextUpto += inc;}while (true) {if (low > high) {upto = low;break;}int mid = (low + high) >>> 1;int cmp = docIDs[mid] - target;if (cmp < 0) {low = mid + 1;} else if (cmp > 0) {high = mid - 1;} else {upto = mid;break;}}if (upto == docIDs.length) {return docID = NO_MORE_DOCS;} else {return docID = docIDs[upto];}}
public void setParams(String params) {super.setParams(params);int k = params.indexOf(",");name = params.substring(0,k).trim();value = params.substring(k+1).trim();}
public IgnoreNode(List<FastIgnoreRule> rules) {this.rules = rules;}
public E next() {if (iterator.nextIndex() < end) {return iterator.next();}throw new NoSuchElementException();}
public final String toString() {StringBuilder sb = new StringBuilder();String recordName = getRecordName();sb.append("[").append(recordName).append("]\n");sb.append("    .row    = ").append(HexDump.shortToHex(getRow())).append("\n");sb.append("    .col    = ").append(HexDump.shortToHex(getColumn())).append("\n");if (isBiff2()) {sb.append("    .cellattrs = ").append(HexDump.shortToHex(getCellAttrs())).append("\n");} else {sb.append("    .xfindex   = ").append(HexDump.shortToHex(getXFIndex())).append("\n");}appendValueText(sb);sb.append("\n");sb.append("[/").append(recordName).append("]\n");return sb.toString();}
public GetApplicationResult getApplication(GetApplicationRequest request) {request = beforeClientExecution(request);return executeGetApplication(request);}
public long ramBytesUsed() {long sizeInBytes = 0;sizeInBytes += RamUsageEstimator.sizeOf(minValues);sizeInBytes += RamUsageEstimator.sizeOf(averages);for(PackedInts.Reader reader: subReaders) {sizeInBytes += reader.ramBytesUsed();}return sizeInBytes;}
public DescribeRouteTablesResult describeRouteTables() {return describeRouteTables(new DescribeRouteTablesRequest());}
public DescribeTagsRequest(java.util.List<Filter> filters) {setFilters(filters);}
public String toString() {return "(" + a.toString() + " OR " + b.toString() + ")";}
public DescribeCompanyNetworkConfigurationResult describeCompanyNetworkConfiguration(DescribeCompanyNetworkConfigurationRequest request) {request = beforeClientExecution(request);return executeDescribeCompanyNetworkConfiguration(request);}
public int byteAt(int idx) {return bytes[idx].value;}
public int get(int index) {checkIndex(index);return byteBuffer.getInt(index * SizeOf.INT);}
public static double var(double[] v) {double r = Double.NaN;if (v!=null && v.length > 1) {r = devsq(v) / (v.length - 1);}return r;}
public SynonymQuery build() {Collections.sort(terms, Comparator.comparing(a -> a.term));return new SynonymQuery(terms.toArray(new TermAndBoost[0]), field);}
public int getWeight() {return WEIGHT_UNKNOWN;}
public final void incRef() {ensureOpen();refCount.incrementAndGet();}
public ListFragmentsResult listFragments(ListFragmentsRequest request) {request = beforeClientExecution(request);return executeListFragments(request);}
public int fillFields(byte[] data, int offset, EscherRecordFactory recordFactory) {int bytesAfterHeader = readHeader( data, offset );int pos = offset + HEADER_SIZE;System.arraycopy( data, pos, field_1_UID, 0, 16 ); pos += 16;field_2_marker = data[pos]; pos++;setPictureData(data, pos, bytesAfterHeader - 17);return bytesAfterHeader + HEADER_SIZE;}
public Set<String> getNames(String section, String subsection) {return getState().getNames(section, subsection);}
public boolean equals(Object other) {return sameClassAs(other) &&equalsTo(getClass().cast(other));}
public static FormulaError forInt(int type) throws IllegalArgumentException {FormulaError err = imap.get(type);if(err == null) err = bmap.get((byte)type);if(err == null) throw new IllegalArgumentException("Unknown error type: " + type);return err;}
public boolean equals(Object obj) {if (this == obj) {return true;}if (obj == null) {return false;}if (getClass() != obj.getClass()) {return false;}WeightedPhraseInfo other = (WeightedPhraseInfo) obj;if (getStartOffset() != other.getStartOffset()) {return false;}if (getEndOffset() != other.getEndOffset()) {return false;}if (getBoost() != other.getBoost()) {return false;}return true;}
@Override public boolean remove(Object object) {synchronized (CopyOnWriteArrayList.this) {int index = indexOf(object);if (index == -1) {return false;}remove(index);return true;}}
public final String[] getValues(String name) {List<String> result = new ArrayList<>();for (IndexableField field : fields) {if (field.name().equals(name) && field.stringValue() != null) {result.add(field.stringValue());}}if (result.size() == 0) {return NO_STRINGS;}return result.toArray(new String[result.size()]);}
public DeleteApplicationSnapshotResult deleteApplicationSnapshot(DeleteApplicationSnapshotRequest request) {request = beforeClientExecution(request);return executeDeleteApplicationSnapshot(request);}
public boolean hasTransparentBounds() {return transparentBounds;}
@Override public int size() {synchronized (mutex) {return c.size();}}
public ShortBuffer put(short[] src, int srcOffset, int shortCount) {if (shortCount > remaining()) {throw new BufferOverflowException();}System.arraycopy(src, srcOffset, backingArray, offset + position, shortCount);position += shortCount;return this;}
public void close() {if (sock != null) {try {sch.releaseSession(sock);} finally {sock = null;}}}
public void setDetachingSymbolicRef() {detachingSymbolicRef = true;}
public SoraniStemFilter create(TokenStream input) {return new SoraniStemFilter(input);}
public GetTranscriptResult getTranscript(GetTranscriptRequest request) {request = beforeClientExecution(request);return executeGetTranscript(request);}
public DescribeProblemObservationsResult describeProblemObservations(DescribeProblemObservationsRequest request) {request = beforeClientExecution(request);return executeDescribeProblemObservations(request);}
public RegisterTypeResult registerType(RegisterTypeRequest request) {request = beforeClientExecution(request);return executeRegisterType(request);}
public Object toObject() {assert exists || 0.0D == value;return exists ? value : null;}
public CreatePipelineResult createPipeline(CreatePipelineRequest request) {request = beforeClientExecution(request);return executeCreatePipeline(request);}
public void write(byte[] buffer, int byteOffset, int byteCount) throws IOException {IoBridge.write(fd, buffer, byteOffset, byteCount);if (syncMetadata) {fd.sync();}}
public PutBlockPublicAccessConfigurationResult putBlockPublicAccessConfiguration(PutBlockPublicAccessConfigurationRequest request) {request = beforeClientExecution(request);return executePutBlockPublicAccessConfiguration(request);}
public void endWorker() {if (workers.decrementAndGet() == 0)process.release();}
public HSSFShapeGroup createGroup(HSSFChildAnchor anchor) {HSSFShapeGroup group = new HSSFShapeGroup(this, anchor);group.setParent(this);group.setAnchor(anchor);shapes.add(group);onCreate(group);return group;}
public CreateSecurityGroupResult createSecurityGroup(CreateSecurityGroupRequest request) {request = beforeClientExecution(request);return executeCreateSecurityGroup(request);}
public ObjectId getResultTreeId() {return (resultTree == null) ? null : resultTree.toObjectId();}
public DeleteEnvironmentResult deleteEnvironment(DeleteEnvironmentRequest request) {request = beforeClientExecution(request);return executeDeleteEnvironment(request);}
